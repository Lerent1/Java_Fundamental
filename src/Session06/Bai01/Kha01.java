package Session06.Bai01;

public class Kha01 {
    public static class Student {
        private String id;
        private String name;
        private int date;
        private double avg;

        public Student(String id, String name, int date, double avg) {
            this.id = id;
            this.name = name;
            this.date = date;
            this.avg = avg;
        }

        public void show() {
            System.out.println("Ma sinh vien: " + id);
            System.out.println("Ten sinh vien: " + name);
            System.out.println("date sinh vien: " + date);
            System.out.println("Diem trung binh sinh vien: " + avg);
        }
    }

    public static void main(String[] args) {
        Student hocSinh = new Student("01", "Nguyen Tuan Minh", 2006, 10);

        hocSinh.show();
    }
}
