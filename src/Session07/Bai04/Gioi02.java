package Session07.Bai04;

import java.util.ArrayList;
import java.util.List;

class Order {
    String id;

    public Order(String id) {
        this.id = id;
    }
}

interface OrderRepository {
    void save(Order order);
    List<Order> findAll();
}

interface NotificationService {
    void send(String message, String recipient);
}

class FileOrderRepository implements OrderRepository {
    List<Order> orders = new ArrayList<>();
    public void save(Order order) {
        orders.add(order);
        System.out.println("Luu don hang vao file: " + order.id);
    }

    public List<Order> findAll() {
        return orders;
    }
}

class DatabaseOrderRepository implements OrderRepository {
    List<Order> orders = new ArrayList<>();
    public void save(Order order) {
        orders.add(order);
        System.out.println("Luu don hang vao database: " + order.id);
    }

    public List<Order> findAll() {
        return orders;
    }
}

class EmailService implements NotificationService {
    public void send(String message, String recipient) {
        System.out.println("Gui email: " + message);
    }
}

class SMSNotification implements NotificationService {
    public void send(String message, String recipient) {
        System.out.println("Gui SMS: " + message);
    }
}

class OrderService {
    private OrderRepository orderRepository;
    private NotificationService notificationService;

    public OrderService(OrderRepository orderRepository, NotificationService notificationService) {
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
    }

    public void createOrder(Order order, String recipient) {
        orderRepository.save(order);
        notificationService.send("Don hang " + order.id + " da duoc tao", recipient);
    }
}

public class Gioi02 {
    public static void main(String[] args) {
        System.out.println("Dung FileOrderRepository va EmailService");

        OrderRepository repo1 = new FileOrderRepository();
        NotificationService notify1 = new EmailService();

        OrderService service1 = new OrderService(repo1, notify1);

        Order order1 = new Order("ORD001");
        System.out.println("Tao don hang ORD001");
        service1.createOrder(order1, "user@email.com");

        System.out.println();

        System.out.println("Doi sang DatabaseOrderRepository va SMSNotification");

        OrderRepository repo2 = new DatabaseOrderRepository();
        NotificationService notify2 = new SMSNotification();

        OrderService service2 = new OrderService(repo2, notify2);

        Order order2 = new Order("ORD002");
        System.out.println("Tao don hang ORD002");
        service2.createOrder(order2, "0123456789");
    }
}
