package Session15.Bai05;

import java.util.Stack;

public class EmergencyCase {
    private String patientId;
    private String patientName;
    private Stack<TreatmentStep> steps;

    public EmergencyCase(String patientId, String patientName) {
        this.patientId = patientId;
        this.patientName = patientName;
        steps = new Stack<>();
    }

    public void addStep(TreatmentStep step) {
        steps.push(step);
        System.out.println("Them buoc: " + step);
    }

    public TreatmentStep undoStep() {
        if (!steps.isEmpty()) {
            return steps.pop();
        }
        System.out.println("Khong co buoc de undo");
        return null;
    }

    public void displaySteps() {
        System.out.println("Benh nhan: " + patientId + " - " + patientName);

        for (TreatmentStep step : steps) {
            System.out.println(step);
        }
    }
}
