package Session15.Bai04;

public class Gioi02 {
    public static void main(String[] args) {
        EmergencyQueue eq = new EmergencyQueue();

        eq.addPatient(new EmergencyPatient("P01","An",2));
        eq.addPatient(new EmergencyPatient("P02","Binh",1));
        eq.addPatient(new EmergencyPatient("P03","Cuong",2));
        eq.addPatient(new EmergencyPatient("P04","Dung",1));
        eq.displayQueue();

        eq.callNextPatient();
        eq.callNextPatient();
        eq.callNextPatient();
    }
}
