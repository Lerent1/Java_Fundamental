package Session07.Bai01;

import java.util.ArrayList;
import java.util.List;

class Product {
    String id;
    String name;
    double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Customer {
    String name;
    String email;
    String address;

    public Customer(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }
}

class OrderItem {
    Product product;
    int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}

class Order {
    String orderId;
    Customer customer;
    List<OrderItem> items;
    double total;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        items.add(new OrderItem(product, quantity));
    }
}

class OrderCalculator {
    public double calculateTotal(Order order) {
        double total = 0;
        for (OrderItem item : order.items) {
            total += item.product.price * item.quantity;
        }
        return total;
    }
}

class OrderRepository {
    List<Order> orders = new ArrayList<>();

    public void save(Order order) {
        orders.add(order);
        System.out.println("Da luu don hang " + order.orderId);
    }
}

class EmailService {
    public void sendEmail(String email, String message) {
        System.out.println("Da gui email den " + email + ": " + message);
    }
}

public class Kha01 {
    public static void main(String[] args) {
        Product p1 = new Product("SP01", "Laptop", 15000000);
        Product p2 = new Product("SP02", "Chuot", 300000);

        System.out.println("Da them san pham SP01, SP02");

        Customer customer = new Customer("Nguyen Van A", "a@example.com", "Ha Noi");

        System.out.println("Da them khach hang");

        Order order = new Order("ORD001", customer);
        order.addItem(p1, 1);
        order.addItem(p2, 2);

        System.out.println("Don hang ORD001 duoc tao");

        System.out.println("Tinh tong tien");
        OrderCalculator calculator = new OrderCalculator();

        double total = calculator.calculateTotal(order);
        order.total = total;

        System.out.println("Tong tien: " + (int) total);

        System.out.println("Luu don hang");
        OrderRepository repo = new OrderRepository();
        repo.save(order);

        System.out.println("Gui email xac nhan");
        EmailService emailService = new EmailService();

        emailService.sendEmail(customer.email, "Don hang " + order.orderId + " da duoc tao");
    }
}