package Session01.Bai05;

public class XuatSac01 {
    public static void main(String[] args) {
        User user = new User();

        try {
            user.setAge(-3);
            System.out.println("Tuoi: " + user.getAge());
        } catch (InvalidAgeException e) {
            System.out.println("Loi: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Chuong trinh van tiep tuc...");
    }
}
