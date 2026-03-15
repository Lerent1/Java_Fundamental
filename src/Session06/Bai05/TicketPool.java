package Session06.Bai05;

import java.util.ArrayList;
import java.util.List;

class TicketPool {
    String roomName;
    List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int capacity) {
        this.roomName = roomName;

        for (int i = 1; i <= capacity; i++) {
            tickets.add(new Ticket(roomName + "-" + String.format("%03d", i)));
        }
    }

    public synchronized Ticket holdTicket(boolean isVIP, String counterName) {

        for (Ticket t : tickets) {

            if (!t.sold && !t.isHeld) {

                t.isHeld = true;
                t.isVIP = isVIP;
                t.holdExpiryTime = System.currentTimeMillis() + 5000;

                System.out.println(counterName + ": Da giu ve " + t.id +
                        (isVIP ? " (VIP)" : "") + ". Thanh toan trong 5s");

                return t;
            }
        }

        System.out.println(counterName + ": Khong con ve trong phong " + roomName);
        return null;
    }

    public synchronized void sellHeldTicket(Ticket t, String counterName) {
        if (t != null && t.isHeld && !t.sold) {

            t.sold = true;
            t.isHeld = false;

            System.out.println(counterName + ": Thanh toan thanh cong " + t.id);
        }
    }

    public synchronized void releaseExpiredTickets() {
        long now = System.currentTimeMillis();
        for (Ticket t : tickets) {
            if (t.isHeld && !t.sold && now > t.holdExpiryTime) {
                t.isHeld = false;
                System.out.println("TimeoutManager: Ve " + t.id + " het han giu, da tra lai kho");
            }
        }
    }
}