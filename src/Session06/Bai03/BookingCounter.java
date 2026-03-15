package Session06.Bai03;

class BookingCounter extends Thread {
    private String counterName;
    private TicketPool roomA;
    private TicketPool roomB;
    private boolean lockAFirst;

    public BookingCounter(String name, TicketPool a, TicketPool b, boolean lockAFirst) {
        this.counterName = name;
        this.roomA = a;
        this.roomB = b;
        this.lockAFirst = lockAFirst;
    }

    public void run() {
        sellCombo();
    }

    public void sellCombo() {
        TicketPool first = lockAFirst ? roomA : roomB;
        TicketPool second = lockAFirst ? roomB : roomA;

        synchronized (first) {
            System.out.println(counterName + ": Da lay khoa " + first.getRoomName());

            try { Thread.sleep(100); } catch (Exception e) {}

            synchronized (second) {
                System.out.println(counterName + ": Da lay khoa " + second.getRoomName());

                if (roomA.hasTicket() && roomB.hasTicket()) {
                    String ticketA = roomA.takeTicket();
                    String ticketB = roomB.takeTicket();

                    System.out.println(counterName + " ban combo thanh cong: "
                            + ticketA + " & " + ticketB);
                } else {
                    System.out.println(counterName + ": Het ve, giao dich that bai");
                }
            }
        }
    }
}
