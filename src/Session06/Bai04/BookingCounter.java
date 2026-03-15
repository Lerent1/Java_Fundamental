package Session06.Bai04;

class BookingCounter extends Thread {
    private String counterName;
    private TicketPool ticketPool;

    public BookingCounter(String name, TicketPool pool) {
        this.counterName = name;
        this.ticketPool = pool;
    }

    public void run() {
        while (true) {
            ticketPool.sellTicket(counterName);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
