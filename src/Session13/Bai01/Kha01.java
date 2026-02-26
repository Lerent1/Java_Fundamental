package Session13.Bai01;

import java.util.ArrayList;
import java.util.Iterator;

public class Kha01 {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();
        list.add(36.5);
        list.add(40.2);
        list.add(37.0);
        list.add(12.5);
        list.add(39.8);
        list.add(99.9);
        list.add(36.8);

        System.out.println("Danh sách ban đầu: " + list);

        Iterator<Double> it = list.iterator();

        while (it.hasNext()) {
            Double nhietDo = it.next();
            if (nhietDo < 34.0 || nhietDo > 42.0) {
                it.remove();
            }
        }

        System.out.println("Danh sách sau khi lọc: " + list);

        double tong = 0;
        for (Double nhietDo : list) {
            tong += nhietDo;
        }

        double trungBinh = tong / list.size();

        System.out.printf("Nhiệt độ trung bình: %.2f", trungBinh);
    }
}
