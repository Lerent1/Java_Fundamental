package Session07.Bai04;

public class Gioi02 {
    public static class ClassRoom {
        static double classFund = 0;
        private String studentName;

        public ClassRoom(String studentName) {
            this.studentName = studentName;
        }

        public void contribute(double amount) {
            classFund += amount;
            System.out.println(studentName + " dong " + amount + " vao quy lop");
        }

        public static void showClassFund() {
            System.out.println("Tong quy lop hien tai: " + classFund);
        }
    }

    public static void main(String[] args) {
        ClassRoom sv1 = new ClassRoom("Minh");
        ClassRoom sv2 = new ClassRoom("Thang");
        ClassRoom sv3 = new ClassRoom("Loc");

        sv1.contribute(100_000);
        sv2.contribute(150_000);
        sv3.contribute(200_000);

        ClassRoom.showClassFund();
    }
}
