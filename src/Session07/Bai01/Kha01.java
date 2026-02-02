package Session07.Bai01;

public class Kha01 {
    static class Student {
        private String studentId;
        private String studentName;
        private static int totalStudent = 0;

        public Student(String studentId, String studentName) {
            this.studentId = studentId;
            this.studentName = studentName;
            totalStudent++;
        }

        public void displayInfo() {
            System.out.println("Ma sinh vien: " + studentId);
            System.out.println("Ten sinh vien: " + studentName);
        }

        public static void displayTotalStudent() {
            System.out.println("Tong so sinh vien da tao: " + totalStudent);
        }
    }

    public static void main(String[] args) {

        Student s1 = new Student("SV001", "Nguyen Van A");
        Student s2 = new Student("SV002", "Tran Thi B");
        Student s3 = new Student("SV003", "Le Van C");

        s1.displayInfo();
        s2.displayInfo();
        s3.displayInfo();

        Student.displayTotalStudent();
    }
}