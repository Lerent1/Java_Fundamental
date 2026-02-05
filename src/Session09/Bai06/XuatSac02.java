package Session09.Bai06;

import java.util.ArrayList;

public class XuatSac02 {
    public static void main(String[] args) {

        ArrayList<shape> shapes = new ArrayList<>();

        shapes.add(new circle(5));
        shapes.add(new rectangle(4, 6));
        shapes.add(new circle());
        shapes.add(new rectangle());

        double total = 0;

        for (shape s : shapes) {
            double area = s.area();
            System.out.println("Dien tich: " + area);
            total += area;
        }

        System.out.println("Tong dien tich: " + total);
    }
}

