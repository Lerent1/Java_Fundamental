package Session13.Bai03;

import java.util.ArrayList;
import java.util.List;

public class Gioi01 {
    public static <T> List<T> findCommonPatients(List<T> listA, List<T> listB) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < listA.size(); i++) {
            T item = listA.get(i);
            if (listB.contains(item) && !result.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> khoaNoi_ID = new ArrayList<>();
        khoaNoi_ID.add(101);
        khoaNoi_ID.add(102);
        khoaNoi_ID.add(105);

        List<Integer> khoaNgoai_ID = new ArrayList<>();
        khoaNgoai_ID.add(102);
        khoaNgoai_ID.add(105);
        khoaNgoai_ID.add(108);

        List<Integer> ketQua1 = findCommonPatients(khoaNoi_ID, khoaNgoai_ID);
        System.out.println(ketQua1);

        List<String> khoaNoi_BHYT = new ArrayList<>();
        khoaNoi_BHYT.add("DN01");
        khoaNoi_BHYT.add("DN02");
        khoaNoi_BHYT.add("DN03");

        List<String> khoaNgoai_BHYT = new ArrayList<>();
        khoaNgoai_BHYT.add("DN02");
        khoaNgoai_BHYT.add("DN04");

        List<String> ketQua2 = findCommonPatients(khoaNoi_BHYT, khoaNgoai_BHYT);
        System.out.println(ketQua2);
    }
}