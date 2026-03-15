package Session06.Bai04;

class Supplier extends Thread {
    private TicketPool ticketPool;

    public Supplier(TicketPool pool) {
        this.ticketPool = pool;
    }

    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ticketPool.addTickets(3);
    }
}