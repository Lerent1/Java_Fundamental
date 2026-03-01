package Session14.Bai02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Kha02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> medicines = new HashMap<>();
        medicines.put("T01", "Paracetamol");
        medicines.put("T02", "Ibuprofen");
        medicines.put("T03", "Aspirin");
        medicines.put("T04", "Amoxicillin");
        medicines.put("T05", "Vitamin C");

        System.out.print("Hay nap ma thuoc: ");
        String code = sc.nextLine();

        if (medicines.containsKey(code)) {
            System.out.println("Ten thuoc: " + medicines.get(code));
        } else {
            System.out.println("Thuoc khong ton tai");
        }
    }
}
