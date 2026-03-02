package Session15.Bai02;

public class Kha02 {
    public static void main(String[] args) {
        PatientQueue kha02 = new PatientQueue();

        kha02.addPatient(new Patient("P01", "Nguyen Van A", 30));
        kha02.addPatient(new Patient("P02", "Tran Thi B", 25));
        kha02.addPatient(new Patient("P03", "Le Van C", 40));
        kha02.displayQueue();

        System.out.println("\nBenh nhan tiep theo:");
        System.out.println(kha02.peekNextPatient());
        kha02.callNextPatient();

        kha02.displayQueue();
    }
}
