package Session06.Bai03;

public class Gioi01 {
    public static void main(String[] args) {
        TicketPool roomA = new TicketPool("A", 2);
        TicketPool roomB = new TicketPool("B", 2);

        BookingCounter counter1 = new BookingCounter("Quay 1", roomA, roomB, true);
        BookingCounter counter2 = new BookingCounter("Quay 2", roomA, roomB, false);

        counter1.start();
        counter2.start();
    }
}
