package Session15.Bai02;

import java.util.LinkedList;
import java.util.Queue;

public class PatientQueue {
    private Queue<Patient> queue = new LinkedList<>();

    public void addPatient(Patient p) {
        queue.offer(p);
        System.out.println("Da them benh nhan: " + p);
    }

    public Patient callNextPatient() {
        if (queue.isEmpty()) {
            System.out.println("Khong con benh nhan!");
            return null;
        }
        Patient p = queue.poll();
        System.out.println("Dang kham: " + p);
        return p;
    }

    public Patient peekNextPatient() {
        if (queue.isEmpty()) {
            System.out.println("Hang doi rong!");
            return null;
        }
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Khong co benh nhan cho");
            return;
        }
        for (Patient p : queue) {
            System.out.println(p);
        }
    }
}
