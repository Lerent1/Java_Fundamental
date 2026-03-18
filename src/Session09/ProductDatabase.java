package Session09;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private static ProductDatabase instance;
    private List<Product> products;

    ProductDatabase() {
        products = new ArrayList<>();
    }

    public static ProductDatabase getInstance() {
        if (instance == null) {
            instance = new ProductDatabase();
        }
        return instance;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void deleteProduct(String id) {
        Product found = null;
        for (Product p : products) {
            if (p.getId().equals(id)) {
                found = p;
                break;
            }
        }
        if (found != null) {
            products.remove(found);
            System.out.println("Xoa thanh cong");
        } else {
            System.out.println("Khong tim thay");
        }
    }

    public Product findById(String id) {
        for (Product p : products) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    public List<Product> getAll() {
        return products;
    }
}