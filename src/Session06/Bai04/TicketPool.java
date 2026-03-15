package Session06.Bai04;

class TicketPool {
    private String roomName;
    private int ticketCount;
    private int ticketNumber = 1;

    public TicketPool(String roomName, int ticketCount) {
        this.roomName = roomName;
        this.ticketCount = ticketCount;
    }

    public synchronized String sellTicket(String counterName) {
        while (ticketCount == 0) {
            try {
                System.out.println(counterName + ": Het ve phong " + roomName + ", dang cho...");
                wait(); // Thread chờ khi hết vé
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String ticket = roomName + "-" + String.format("%03d", ticketNumber++);
        ticketCount--;

        System.out.println(counterName + " ban ve " + ticket);
        return ticket;
    }

    public synchronized void addTickets(int amount) {
        ticketCount += amount;
        System.out.println("Nha cung cap: Da them " + amount + " ve vao phong " + roomName);
        notifyAll();
    }
}
