package Session04.Bai02;

public class Kha02 {
    public static void main(String[] args) {
        String description = "ko biet sach gi. Ke: A12-B3, Minh";
        if (description.contains("Ke:")) {
            int start = description.indexOf("Ke:") + 4;
            int end = description.indexOf(",", start);
            String code;
            if (end != -1) {
                code = description.substring(start, end).trim();
            } else {
                code = description.substring(start).trim();
            }
            String newDescription = description.replace("Ke:", "Vi tri:");
            System.out.println("Ma vi tri ke sach: " + code);
            System.out.println("Mo ta moi: " + newDescription);
        } else {
            System.out.println("Khong tim thay ke sach");
        }
    }
}
