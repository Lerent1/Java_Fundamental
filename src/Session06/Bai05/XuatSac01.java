package Session06.Bai05;

public class XuatSac01 {
    public static class Book {
        private String maSach;
        private String tenSach;
        private double gia;

        public Book(String maSach, String tenSach, double gia) {
            this.maSach = maSach;
            this.tenSach = tenSach;
            this.gia = gia;
        }

        public void hienThiThongTin() {
            System.out.println("Ma sach: " + maSach);
            System.out.println("Ten sach: " + tenSach);
            System.out.println("Gia: " + gia);
        }
    }

    public static void main(String[] args) {
        Book b = new Book("S01", "Lap trinh Java", 95000);
        b.hienThiThongTin();
    }
}
