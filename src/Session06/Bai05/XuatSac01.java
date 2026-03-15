package Session06.Bai05;

import java.util.Arrays;
import java.util.List;

public class XuatSac01 {
    public static void main(String[] args) {
        TicketPool roomA = new TicketPool("A", 3);
        TicketPool roomB = new TicketPool("B", 3);
        TicketPool roomC = new TicketPool("C", 3);

        List<TicketPool> pools = Arrays.asList(roomA, roomB, roomC);

        TimeoutManager tm = new TimeoutManager(pools);
        tm.start();

        BookingCounter c1 = new BookingCounter("Quay 1", roomA, true);
        BookingCounter c2 = new BookingCounter("Quay 2", roomA, false);
        BookingCounter c3 = new BookingCounter("Quay 3", roomA, false);
        BookingCounter c4 = new BookingCounter("Quay 4", roomB, true);
        BookingCounter c5 = new BookingCounter("Quay 5", roomC, false);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
    }
}
