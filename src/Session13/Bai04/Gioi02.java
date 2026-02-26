package Session13.Bai04;

import java.util.LinkedList;

public class Gioi02 {
    private LinkedList<String> queue = new LinkedList<>();
    private LinkedList<String> emergencyList = new LinkedList<>();

    public void patientCheckIn(String name) {
        queue.addLast(name);
    }

    public void emergencyCheckIn(String name) {
        queue.addFirst(name);
        emergencyList.add(name);
    }

    public void treatPatient() {
        if (queue.isEmpty()) {
            System.out.println("Khong co benh nhan");
            return;
        }

        String name = queue.removeFirst();
        if (emergencyList.contains(name)) {
            System.out.println("Dang cap cuu: " + name);
            emergencyList.remove(name);
        } else {
            System.out.println("Dang kham: " + name);
        }
    }

    public static void main(String[] args) {
        Gioi02 er = new Gioi02();
        er.patientCheckIn("A");
        er.patientCheckIn("B");
        er.emergencyCheckIn("C");
        er.treatPatient();
        er.treatPatient();
        er.treatPatient();
    }
}