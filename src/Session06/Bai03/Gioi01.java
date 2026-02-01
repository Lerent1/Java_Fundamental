package Session06.Bai03;

public class Gioi01 {
    public static class Product {
        private String maSP;
        private String tenSP;
        private double giaBan;

        public Product(String maSP, String tenSP, double giaBan) {
            this.maSP = maSP;
            this.tenSP = tenSP;
            setGiaBan(giaBan);
        }
        public String getMaSP() {
            return maSP;
        }
        public String getTenSP() {
            return tenSP;
        }
        public double getGiaBan() {
            return giaBan;
        }
        public void setMaSP(String maSP) {
            this.maSP = maSP;
        }
        public void setTenSP(String tenSP) {
            this.tenSP = tenSP;
        }

        public void setGiaBan(double giaBan) {
            if (giaBan > 0) {
                this.giaBan = giaBan;
            } else {
                System.out.println("Giá bán không hợp lệ! Giá phải > 0");
            }
        }

        public void hienThiThongTin() {
            System.out.println("Mã SP: " + maSP);
            System.out.println("Tên SP: " + tenSP);
            System.out.println("Giá bán: " + giaBan);
        }
    }

    public static void main(String[] args) {
        Product p = new Product("SP01", "Tya cam", 1200000);

        System.out.println("Thong tin ban dau:");
        p.hienThiThongTin();

        System.out.println("\nThu set gia khong hop le:");
        p.setGiaBan(-500000);

        System.out.println("\nThong tin sau khi set gia sai:");
        p.hienThiThongTin();
    }
}
