package Session15.Bai05;

public class XuatSac01 {
    public static void main(String[] args) {
        EmergencyCaseQueue queue = new EmergencyCaseQueue();
        EmergencyCase c1 = new EmergencyCase("BN01", "Nguyen Van A");
        EmergencyCase c2 = new EmergencyCase("BN02", "Tran Thi B");
        queue.addCase(c1);
        queue.addCase(c2);

        EmergencyCase current = queue.getNextCase();

        current.addStep(new TreatmentStep("Tiep nhan", "08:00"));
        current.addStep(new TreatmentStep("Chan doan", "08:05"));
        current.addStep(new TreatmentStep("Dieu tri", "08:10"));
        current.displaySteps();

        System.out.println("\nUndo:");
        current.undoStep();

        current.displaySteps();
    }
}
