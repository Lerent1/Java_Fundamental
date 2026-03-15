package Session06.Bai05;

class Ticket {
    String id;
    boolean isHeld = false;
    boolean isVIP;
    long holdExpiryTime = 0;
    boolean sold = false;

    public Ticket(String id) {
        this.id = id;
    }
}
