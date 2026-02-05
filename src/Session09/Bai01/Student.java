package Session09.Bai01;

public class Student extends Person {
    private String studentId;
    private double gpa;

    public Student(String name, int age, String studentId, double gpa) {
        super(name, age);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Ma sinh vien: " + studentId);
        System.out.println("Diem trung binh: " + gpa);
    }
}