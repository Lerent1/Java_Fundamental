package Session15.Bai01;

public class Kha01 {
    public static void main(String[] args) {
        MedicalRecordHistory record = new MedicalRecordHistory();

        record.addEdit(new EditAction("Cap nhat nhiet do benh nhan", "09:00"));
        record.addEdit(new EditAction("Them ket qua xet nghiem", "09:15"));
        record.addEdit(new EditAction("Chinh sua don thuoc", "09:30"));
        record.displayHistory();

        System.out.println("\nChinh sua gan nhat:");
        System.out.println(record.getLatestEdit());
        record.undoEdit();

        record.displayHistory();
    }
}
