package Session06.Bai05;

class BookingCounter extends Thread {

    String name;
    TicketPool pool;
    boolean vip;

    public BookingCounter(String name, TicketPool pool, boolean vip) {
        this.name = name;
        this.pool = pool;
        this.vip = vip;
    }

    public void run() {

        try {

            Ticket t = pool.holdTicket(vip, name);

            if (t != null) {

                Thread.sleep(3000); // khách suy nghĩ

                pool.sellHeldTicket(t, name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
