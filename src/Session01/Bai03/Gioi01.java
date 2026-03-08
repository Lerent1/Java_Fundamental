package Session01.Bai03;

public class Gioi01 {
    public static void main(String[] args) {
        User user = new User();

        try {
            user.setAge(-5);
            System.out.println("Tuoi: " + user.getAge());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
