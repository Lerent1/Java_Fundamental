package Session03.Bai03;

public class Gioi01 {
    public static void main(String[] args) {
        String[] names = {"Doraemon", "Khong gia dinh", "ghi cho co", "ko biet", "vi du"
        };

        int[] quantities = {10, 3, 10, 5, 3};

        int max = quantities[0];
        for (int i = 1; i < quantities.length; i++) {
            if (quantities[i] > max) {
                max = quantities[i];
            }
        }

        System.out.println("Sach co so luong nhieu nhat: ");
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] == max) {
                System.out.println("- " + names[i] + " (" + quantities[i] + ")");
            }
        }

        int min = quantities[0];
        for (int i = 1; i < quantities.length; i++) {
            if (quantities[i] < min) {
                min = quantities[i];
            }
        }

        System.out.println("Sach co so luong it nhat: ");
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] == min) {
                System.out.println("- " + names[i] + " (" + quantities[i] + ")");
            }
        }
    }
}