package Session06.Bai01;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {

    private Queue<Ticket> tickets = new LinkedList<>();
    private String roomName;
    private int ticketCounter = 1;

    public TicketPool(String roomName, int initialTickets) {
        this.roomName = roomName;

        for (int i = 0; i < initialTickets; i++) {
            String id = roomName + "-" + String.format("%03d", ticketCounter++);
            tickets.add(new Ticket(id));
        }
    }

    public synchronized Ticket sellTicket() {
        if (!tickets.isEmpty()) {
            return tickets.poll();
        }
        return null;
    }

    public synchronized void addTickets(int count) {
        for (int i = 0; i < count; i++) {
            String id = roomName + "-" + String.format("%03d", ticketCounter++);
            tickets.add(new Ticket(id));
        }
        System.out.println("Nhà cung cấp: Đã thêm " + count + " vé vào phòng " + roomName);
    }

    public synchronized int getRemainingTickets() {
        return tickets.size();
    }
}
