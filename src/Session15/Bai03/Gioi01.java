package Session15.Bai03;

public class Gioi01 {
    public static void main(String[] args) {
        MedicationProcessChecker checker = new MedicationProcessChecker();
        String[] actions = {"PUSH", "PUSH", "POP", "POP"};
        checker.checkProcess(actions);
    }
}
