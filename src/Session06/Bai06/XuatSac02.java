package Session06.Bai06;

import java.util.*;
import java.util.concurrent.*;
import java.lang.management.*;

public class XuatSac02 {
    static class Ticket {
        String id;
        boolean sold = false;
        int price = 125000;

        public Ticket(String id) {
            this.id = id;
        }
    }

    static class TicketPool {
        String roomName;
        List<Ticket> tickets = new ArrayList<>();

        public TicketPool(String roomName, int capacity) {

            this.roomName = roomName;

            for (int i = 1; i <= capacity; i++) {
                tickets.add(new Ticket(roomName + "-" + i));
            }
        }

        public synchronized Ticket sellTicket() {

            for (Ticket t : tickets) {

                if (!t.sold) {
                    t.sold = true;
                    return t;
                }
            }

            return null;
        }

        public synchronized int soldCount() {

            int count = 0;

            for (Ticket t : tickets) {
                if (t.sold) count++;
            }

            return count;
        }

        public int total() {
            return tickets.size();
        }

        public synchronized void addTickets(int amount) {

            int start = tickets.size() + 1;

            for (int i = 0; i < amount; i++) {
                tickets.add(new Ticket(roomName + "-" + (start + i)));
            }

            System.out.println("Da them " + amount + " ve vao phong " + roomName);
        }
    }

    static class BookingCounter implements Runnable {

        String name;
        List<TicketPool> pools;

        volatile boolean running = true;
        volatile boolean paused = false;

        public BookingCounter(String name, List<TicketPool> pools) {
            this.name = name;
            this.pools = pools;
        }

        public void run() {
            Random rand = new Random();

            while (running) {
                try {
                    if (paused) {
                        Thread.sleep(500);
                        continue;
                    }
                    TicketPool pool = pools.get(rand.nextInt(pools.size()));

                    Ticket t = pool.sellTicket();

                    if (t != null) {
                        System.out.println(name + " ban ve " + t.id);
                    }
                    Thread.sleep(500);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Statistics {
        public static void show(List<TicketPool> pools) {
            int totalRevenue = 0;

            System.out.println("\n=== THONG KE HIEN TAI ===");
            for (TicketPool p : pools) {
                int sold = p.soldCount();
                int total = p.total();

                System.out.println("Phong " + p.roomName + ": Da ban " + sold + "/" + total + " ve");
                totalRevenue += sold * 125000;
            }

            System.out.println("Tong doanh thu: " + totalRevenue + " VND\n");
        }
    }

    static class DeadlockDetector {
        public static void detect() {
            ThreadMXBean bean = ManagementFactory.getThreadMXBean();

            long[] ids = bean.findDeadlockedThreads();

            System.out.println("Dang quet deadlock...");

            if (ids != null) {
                System.out.println("PHAT HIEN DEADLOCK!");

                ThreadInfo[] infos = bean.getThreadInfo(ids);

                for (ThreadInfo info : infos) {
                    System.out.println(info.getThreadName());
                }

            } else {
                System.out.println("Khong phat hien deadlock.");
            }
        }
    }

    static class CinemaSystem {
        List<TicketPool> pools = new ArrayList<>();
        List<BookingCounter> counters = new ArrayList<>();

        ExecutorService executor;

        boolean started = false;

        public void start(int rooms, int ticketsPerRoom, int countersNum) {

            if (started) {
                System.out.println("He thong da chay.");
                return;
            }

            for (int i = 0; i < rooms; i++) {
                char name = (char) ('A' + i);

                pools.add(new TicketPool("" + name, ticketsPerRoom));
            }

            executor = Executors.newFixedThreadPool(countersNum);

            for (int i = 1; i <= countersNum; i++) {

                BookingCounter c = new BookingCounter("Quay " + i, pools);

                counters.add(c);

                executor.execute(c);
            }

            started = true;

            System.out.println("Da khoi tao he thong voi "
                    + rooms + " phong, "
                    + (rooms * ticketsPerRoom) + " ve, "
                    + countersNum + " quay");
        }

        public void pause() {

            for (BookingCounter c : counters) {
                c.paused = true;
            }

            System.out.println("Da tam dung mo phong.");
        }

        public void resume() {

            for (BookingCounter c : counters) {
                c.paused = false;
            }

            System.out.println("Da tiep tuc hoat dong.");
        }

        public void addTickets(String room, int amount) {

            for (TicketPool p : pools) {

                if (p.roomName.equals(room)) {
                    p.addTickets(amount);
                    return;
                }
            }

            System.out.println("Phong khong ton tai.");
        }

        public void showStats() {
            Statistics.show(pools);
        }

        public void detectDeadlock() {
            DeadlockDetector.detect();
        }

        public void stop() {

            for (BookingCounter c : counters) {
                c.running = false;
            }

            executor.shutdown();

            System.out.println("Dang dung he thong...");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CinemaSystem system = new CinemaSystem();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Bat dau mo phong");
            System.out.println("2. Tam dung mo phong");
            System.out.println("3. Tiep tuc mo phong");
            System.out.println("4. Them ve vao phong");
            System.out.println("5. Xem thong ke");
            System.out.println("6. Phat hien deadlock");
            System.out.println("7. Thoat");
            System.out.print("Chon: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("So phong: ");
                    int rooms = sc.nextInt();
                    System.out.print("So ve/phong: ");
                    int tickets = sc.nextInt();
                    System.out.print("So quay: ");
                    int counters = sc.nextInt();
                    system.start(rooms, tickets, counters);
                    break;
                case 2:
                    system.pause();
                    break;
                case 3:
                    system.resume();
                    break;
                case 4:
                    System.out.print("Nhap phong (A/B/C): ");
                    String room = sc.next();
                    System.out.print("So ve them: ");
                    int amount = sc.nextInt();
                    system.addTickets(room, amount);
                    break;
                case 5:
                    system.showStats();
                    break;
                case 6:
                    system.detectDeadlock();
                    break;
                case 7:
                    system.stop();
                    System.out.println("Ket thuc chuong trinh.");
                    System.exit(0);
            }
        }
    }
}
