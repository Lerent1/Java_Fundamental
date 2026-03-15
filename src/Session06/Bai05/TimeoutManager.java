package Session06.Bai05;

import java.util.List;

class TimeoutManager extends Thread {
    List<TicketPool> pools;

    public TimeoutManager(List<TicketPool> pools) {
        this.pools = pools;
    }

    public void run() {

        while (true) {

            for (TicketPool p : pools) {
                p.releaseExpiredTickets();
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
