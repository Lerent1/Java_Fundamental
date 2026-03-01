package Session14.Bai06;

import java.util.*;

class Patient {
    String name;
    int age;
    String department;

    public Patient(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class XuatSac02 {
    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
                new Patient("Lan", 30, "Tim mach"),
                new Patient("Hùng", 45, "Noi tiet"),
                new Patient("Mai", 25, "Tim mach")
        );

        Map<String, List<Patient>> departmentMap = new HashMap<>();

        for (int i = 0; i < patients.size(); i++) {
            Patient p = patients.get(i);
            if (!departmentMap.containsKey(p.department)) {
                departmentMap.put(p.department, new ArrayList<>());
            }
            departmentMap.get(p.department).add(p);
        }

        System.out.println("Danh sach theo khoa:");
        for (Map.Entry<String, List<Patient>> entry : departmentMap.entrySet()) {
            System.out.println("Khoa " + entry.getKey() + " -> " + entry.getValue());
        }

        String maxDept = "";
        int maxSize = 0;
        for (Map.Entry<String, List<Patient>> entry : departmentMap.entrySet()) {
            if (entry.getValue().size() > maxSize) {
                maxSize = entry.getValue().size();
                maxDept = entry.getKey();
            }
        }

        System.out.println("\nKhoa " + maxDept + " dang dong nhat (" + maxSize + " benh nhan)");
    }
}
