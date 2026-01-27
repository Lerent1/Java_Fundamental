package Session03.Bai02;

import java.util.Scanner;

public class Kha02 {
    public static void main(String[] args) {
        Scanner kha02 = new Scanner(System.in);

        String[] books = {"Doraemon", "Nhung nguoi khon kho", "Khong gia dinh"};
        System.out.print("Hay nhap ten sach can tim: ");
        String search = kha02.nextLine();

        int index = -1;
        for (int i = 0; i < books.length; i++) {
            if (books[i].equalsIgnoreCase(search)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println("Tim thay sach tai vi tri " + index);
        } else {
            System.out.println("Sach ko ton tai");
        }
    }
}
