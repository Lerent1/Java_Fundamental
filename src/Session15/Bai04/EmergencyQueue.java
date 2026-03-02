package Session15.Bai04;

import java.util.LinkedList;
import java.util.Queue;

public class EmergencyQueue {
    private Queue<EmergencyPatient> emergencyQueue = new LinkedList<>();
    private Queue<EmergencyPatient> normalQueue = new LinkedList<>();

    public void addPatient(EmergencyPatient p) {
        if (p.getPriority() == 1) {
            emergencyQueue.offer(p);
            System.out.println("Them CAP CUU: " + p);
        } else {
            normalQueue.offer(p);
            System.out.println("Them THUONG: " + p);
        }
    }

    public EmergencyPatient callNextPatient() {
        EmergencyPatient p;
        if (!emergencyQueue.isEmpty()) {
            p = emergencyQueue.poll();
        } else if (!normalQueue.isEmpty()) {
            p = normalQueue.poll();
        } else {
            System.out.println("Khong con benh nhan!");
            return null;
        }
        System.out.println("Dang kham: " + p);
        return p;
    }

    public void displayQueue() {

        System.out.println("\n=== Hang doi CAP CUU ===");
        for (EmergencyPatient p : emergencyQueue)
            System.out.println(p);

        System.out.println("\n=== Hang doi THUONG ===");
        for (EmergencyPatient p : normalQueue)
            System.out.println(p);
    }
}