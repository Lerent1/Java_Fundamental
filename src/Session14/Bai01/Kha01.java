package Session14.Bai01;

import java.util.LinkedHashSet;
import java.util.Set;

public class Kha01 {
    public static void main(String[] args) {

        Set<String> patients = new LinkedHashSet<>();

        patients.add("Nguyen Van A – Yen Bai");
        patients.add("Tran Thi B – Thai Binh");
        patients.add("Nguyễn Văn A – Yên Bái");
        patients.add("Lê Văn C – Hưng Yên");

        System.out.println("Danh sach goi kham: ");
        for (String name : patients) {
            System.out.println(name);
        }
    }
}
