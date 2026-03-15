package Session06.Bai03;

class TicketPool {
    private String roomName;
    private int tickets;

    public TicketPool(String roomName, int tickets) {
        this.roomName = roomName;
        this.tickets = tickets;
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean hasTicket() {
        return tickets > 0;
    }

    public String takeTicket() {
        if (tickets > 0) {
            String ticket = roomName + "-" + tickets;
            tickets--;
            return ticket;
        }
        return null;
    }

    public void returnTicket() {
        tickets++;
    }
}
