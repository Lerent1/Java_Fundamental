package Session10.Bai06;

import java.util.*;

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - " + price;
    }
}

public class XuatSac02 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 20000));
        products.add(new Product("Mouse", 500));
        products.add(new Product("Keyboard", 1500));
        products.add(new Product("Monitor", 4000));

        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.price, p2.price);
            }
        });

        System.out.println("Sap xep theo gia tang dan: ");
        for (Product p : products) {
            System.out.println(p);
        }
        Collections.sort(products, (p1, p2) -> p1.name.compareTo(p2.name));

        System.out.println("\nSap xep theo ten A-Z: ");
        products.forEach(p -> System.out.println(p));
    }
}
