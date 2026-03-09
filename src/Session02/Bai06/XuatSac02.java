package Session02.Bai06;

public class XuatSac02 {
    public static void main(String[] args) {
        UserProcessor processor = UserUtils::convertToUpperCase;
        User user = new User("minh");
        String result = processor.process(user);
        System.out.println("Username sau khi chuyển: " + result);
    }
}
