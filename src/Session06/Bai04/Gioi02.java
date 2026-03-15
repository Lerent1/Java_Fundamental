package Session06.Bai04;

public class Gioi02 {
    public static void main(String[] args) {
        TicketPool roomA = new TicketPool("A", 2);
        TicketPool roomB = new TicketPool("B", 5);

        BookingCounter counter1 = new BookingCounter("Quay 1", roomA);
        BookingCounter counter2 = new BookingCounter("Quay 2", roomB);
        Supplier supplier = new Supplier(roomA);

        counter1.start();
        counter2.start();
        supplier.start();
    }
}
