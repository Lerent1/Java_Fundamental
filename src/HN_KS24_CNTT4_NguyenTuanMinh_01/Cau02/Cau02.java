package HN_KS24_CNTT4_NguyenTuanMinh_01.Cau02;

import java.util.*;

public class Cau02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        Map<Integer, Integer> check = new HashMap<>();

        System.out.println("Hay nhap so phan tu ban muon them vao mang: ");
        int n = sc.nextInt();
        if(n <= 0) {
            System.out.println("So luong phan tu khong hop le");
        }

        System.out.println("Hay nhap vao cac phan tu cua mang: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Hay nhap gia tri cua phan tu thu " + (i + 1) + " la: ");
            arr.add(sc.nextInt());
        }

        for(Integer list : arr) {
            if (check.containsKey(list)) {
                check.put(list, check.get(list) + 1);
            } else {
                check.put(list, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : check.entrySet()) {
            System.out.println("So " + entry.getKey() + " xuat hien " + ": " + entry.getValue() + " lan");
        }
    }
}
