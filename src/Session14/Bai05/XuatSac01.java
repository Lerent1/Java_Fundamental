package Session14.Bai05;

import java.util.*;

class Patient {
    String name;
    int severity;
    int arrivalTime;

    public Patient(String name, int severity, int arrivalTime) {
        this.name = name;
        this.severity = severity;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return name + " (Muc " + severity + ", den luc " + arrivalTime + ")";
    }
}

public class XuatSac01 {
    public static void main(String[] args) {
        TreeSet<Patient> queue = new TreeSet<>(
                (p1, p2) -> {
                    if (p1.severity != p2.severity) {
                        return p1.severity - p2.severity;
                    }
                    return p1.arrivalTime - p2.arrivalTime;
                }
        );

        queue.add(new Patient("Benh nhan A", 3, 800));
        queue.add(new Patient("Benh nhan B", 1, 815));
        queue.add(new Patient("Benh nhan C", 1, 805));
        queue.add(new Patient("Benh nhan D", 2, 810));

        System.out.println("Thu tu xu ly cap cuu: ");
        for (Patient p : queue) {
            System.out.println(p);
        }
    }
}
