package Session15.Bai05;

import java.util.LinkedList;
import java.util.Queue;

public class EmergencyCaseQueue {
    private Queue<EmergencyCase> cases = new LinkedList<>();
    public void addCase(EmergencyCase c) {
        cases.offer(c);
        System.out.println("Da them vao hang doi");
    }
    public EmergencyCase getNextCase() {
        return cases.poll();
    }
}
