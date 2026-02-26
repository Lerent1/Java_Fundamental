package Session13.Bai02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kha02 {
    public static List<String> xuLyDanhSach(List<String> input) {
        ArrayList<String> ketQua = new ArrayList<>();
        for (String thuoc : input) {
            if (!ketQua.contains(thuoc)) {
                ketQua.add(thuoc);
            }
        }
        Collections.sort(ketQua);
        return ketQua;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Paracetamol");
        list.add("Ibuprofen");
        list.add("Panadol");
        list.add("Paracetamol");
        list.add("Aspirin");
        list.add("Ibuprofen");

        System.out.println(list);
        List<String> ketQua = xuLyDanhSach(list);
        System.out.println(ketQua);
    }
}
