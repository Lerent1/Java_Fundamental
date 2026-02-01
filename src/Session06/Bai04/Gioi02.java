package Session06.Bai04;

public class Gioi02 {
    public static class Employee {
        private String maNV;
        private String tenNV;
        private double luong;

        public Employee() {
            this.maNV = "Chua co";
            this.tenNV = "Chua co";
            this.luong = 0;
        }
        public Employee(String maNV, String tenNV) {
            this.maNV = maNV;
            this.tenNV = tenNV;
            this.luong = 0;
        }
        public Employee(String maNV, String tenNV, double luong) {
            this.maNV = maNV;
            this.tenNV = tenNV;
            this.luong = luong;
        }

        public void hienThiThongTin() {
            System.out.println("Ma NV: " + maNV);
            System.out.println("Ten NV: " + tenNV);
            System.out.println("Luong: " + luong);
        }
    }

    public static void main(String[] args) {
        System.out.println("Nhan vien 1");
        Employee emp1 = new Employee();
        emp1.hienThiThongTin();

        System.out.println("\nNhan vien 2");
        Employee emp2 = new Employee("NV02", "Nguyen Van A");
        emp2.hienThiThongTin();

        System.out.println("\nNhan vien 3");
        Employee emp3 = new Employee("NV03", "Tran thi B", 15000000);
        emp3.hienThiThongTin();
    }
}
