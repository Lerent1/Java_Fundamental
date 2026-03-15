package Session06.Bai01;

public class Kha01 {
    public static void main(String[] args) {
        TicketPool roomA = new TicketPool("A", 10);
        TicketPool roomB = new TicketPool("B", 10);

        TicketSeller seller1 = new TicketSeller("Quầy 1", roomA);
        TicketSeller seller2 = new TicketSeller("Quầy 2", roomB);

        TicketSupplier supplier = new TicketSupplier(roomA, roomB, 3, 3000, 2);

        Thread t1 = new Thread(seller1);
        Thread t2 = new Thread(seller2);
        Thread supplierThread = new Thread(supplier);

        t1.start();
        t2.start();
        supplierThread.start();

        try {
            t1.join();
            t2.join();
            supplierThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Kết thúc chương trình");

        System.out.println("Vé còn lại phòng A: " + roomA.getRemainingTickets());
        System.out.println("Vé còn lại phòng B: " + roomB.getRemainingTickets());
    }
}
