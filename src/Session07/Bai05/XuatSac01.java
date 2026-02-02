package Session07.Bai05;

public class XuatSac01 {
    public class Config {
        public static final double MAX = 10.0;
        public static final double MIN = 0.0;
        public static void main(String[] args) {
            double score = 8.5;
            System.out.println("Diem hien tai: " + score);
            System.out.println("Diem toi da: " + MAX);
            System.out.println("Diem toi thieu: " + MIN);

            if (score >= MIN && score <= MAX) {
                System.out.println("Diem hop le");
            } else {
                System.out.println("Diem khong hop le");
            }
        }
    }
}
