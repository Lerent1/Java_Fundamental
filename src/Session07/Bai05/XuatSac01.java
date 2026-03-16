package Session07.Bai05;

import java.util.ArrayList;
import java.util.List;

class Product {
    String id;
    String name;
    double price;
    String category;

    public Product(String id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }
}

class Customer {
    String name;
    String email;
    String phone;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}

class OrderItem {
    Product product;
    int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotal() {
        return product.price * quantity;
    }
}

class Order {
    String id;
    Customer customer;
    List<OrderItem> items = new ArrayList<>();
    double finalAmount;

    public Order(String id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public void addItem(Product p, int qty) {
        items.add(new OrderItem(p, qty));
    }

    public double getTotal() {
        double total = 0;
        for (OrderItem i : items) {
            total += i.getTotal();
        }
        return total;
    }
}

interface DiscountStrategy {
    double applyDiscount(double amount);
}

class PercentageDiscount implements DiscountStrategy {
    double percent;
    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    public double applyDiscount(double amount) {
        return amount - amount * percent / 100;
    }
}

class FixedDiscount implements DiscountStrategy {
    double value;
    public FixedDiscount(double value) {
        this.value = value;
    }

    public double applyDiscount(double amount) {
        return amount - value;
    }
}

class HolidayDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount - amount * 0.15;
    }
}

interface PaymentMethod {
    void pay(double amount);
}

class CODPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toan COD: " + (int) amount);
    }
}

class CreditCardPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toan the tin dung: " + (int) amount);
    }
}

class MomoPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toan MoMo: " + (int) amount);
    }
}

class VNPayPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toan VNPay: " + (int) amount);
    }
}

interface OrderRepository {
    void save(Order order);
    List<Order> findAll();
}

class FileOrderRepository implements OrderRepository {
    List<Order> orders = new ArrayList<>();
    public void save(Order order) {
        orders.add(order);
        System.out.println("Da luu don hang " + order.id);
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

interface NotificationService {
    void send(String message);
}

class EmailNotification implements NotificationService {
    public void send(String message) {
        System.out.println("Da gui email: " + message);
    }
}

class SMSNotification implements NotificationService {
    public void send(String message) {
        System.out.println("Da gui SMS: " + message);
    }
}

class InvoiceGenerator {
    public void printInvoice(Order order, double discountAmount) {
        System.out.println("\n=== HOA DON ===");
        System.out.println("Khach: " + order.customer.name);

        for (OrderItem i : order.items) {
            System.out.println(i.product.name + " - So luong: " + i.quantity +
                    " - Don gia: " + (int) i.product.price + " - Thanh tien: " + (int) i.getTotal());
        }

        System.out.println("Tong tien: " + (int) order.getTotal());
        System.out.println("Giam gia: " + (int) discountAmount);
        System.out.println("Can thanh toan: " + (int) order.finalAmount);
    }
}

class OrderService {
    private OrderRepository repository;
    private NotificationService notification;

    public OrderService(OrderRepository repository, NotificationService notification) {
        this.repository = repository;
        this.notification = notification;
    }

    public void processOrder(Order order, DiscountStrategy discount, PaymentMethod payment, InvoiceGenerator invoice) {
        double total = order.getTotal();
        double finalAmount = discount.applyDiscount(total);

        order.finalAmount = finalAmount;

        invoice.printInvoice(order, total - finalAmount);

        payment.pay(finalAmount);

        repository.save(order);

        notification.send("Don hang " + order.id + " da duoc tao");
    }

    public List<Order> getOrders() {
        return repository.findAll();
    }
}

public class XuatSac01 {
    public static void main(String[] args) {
        Product p = new Product("SP01", "Laptop", 15000000, "Dien tu");
        Customer c = new Customer("Nguyen Van A", "a@example.com", "0123456789");
        Order order = new Order("ORD001", c);
        order.addItem(p, 1);

        OrderRepository repo = new FileOrderRepository();
        NotificationService notify = new EmailNotification();

        OrderService service = new OrderService(repo, notify);

        DiscountStrategy discount = new PercentageDiscount(10);

        PaymentMethod payment = new CreditCardPayment();
        InvoiceGenerator invoice = new InvoiceGenerator();

        service.processOrder(order, discount, payment, invoice);
    }
}
