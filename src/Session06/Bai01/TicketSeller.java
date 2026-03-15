package Session06.Bai01;

public class TicketSeller implements Runnable {
    private String sellerName;
    private TicketPool pool;
    private int soldCount = 0;

    public TicketSeller(String sellerName, TicketPool pool) {
        this.sellerName = sellerName;
        this.pool = pool;
    }

    public int getSoldCount() {
        return soldCount;
    }

    @Override
    public void run() {
        while (true) {
            Ticket ticket = pool.sellTicket();

            if (ticket == null) {
                break;
            }

            soldCount++;
            System.out.println(sellerName + " đã bán vé " + ticket.getId());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(sellerName + " bán được: " + soldCount + " vé");
    }
}