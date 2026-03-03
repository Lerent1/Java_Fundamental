package ThucHanhCaNhan;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        IRepository<Product> list = new ProductRepository();

        list.add(new ElectronicProduct("E01","Laptop",15000000,24));
        list.add(new ElectronicProduct("E02","TV",9000000,12));
        list.add(new FoodProduct("F01","Sua",30000,10));
        list.add(new FoodProduct("F02","Banh mi",20000,5));

        List<Product> products = list.findAll();
        for(int i = 0; i < products.size(); i++){
            Product p = products.get(i);
            if (p != null) {
                p.displayInfo();
                System.out.println("Thanh tien: " + p.calculateFinalPrice());
            }
        }

        Product found = list.findById("E01");
        if(found != null){
            found.displayInfo();
        } else {
            System.out.println("Khong tim thay");
        }

        for(int i = 0; i < products.size(); i++){
            products.get(i).displayInfo();
        }

    }
}