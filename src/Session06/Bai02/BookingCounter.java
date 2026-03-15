package Session06.Bai02;

import java.util.Random;

public class BookingCounter implements Runnable {

    private String counterName;
    private TicketPool roomA;
    private TicketPool roomB;
    private int soldCount = 0;

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
    }

    public int getSoldCount() {
        return soldCount;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (roomA.hasTickets() || roomB.hasTickets()) {

            Ticket ticket = null;

            if (random.nextBoolean()) {
                ticket = roomA.sellTicket();
            } else {
                ticket = roomB.sellTicket();
            }

            if (ticket == null) {
                if (roomA.hasTickets()) {
                    ticket = roomA.sellTicket();
                } else if (roomB.hasTickets()) {
                    ticket = roomB.sellTicket();
                }
            }

            if (ticket != null) {
                soldCount++;
                System.out.println(counterName + " đã bán vé " + ticket.getTicketId());
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(counterName + " bán được: " + soldCount + " vé");
    }
}
