package Session02.Bai02;

import java.util.Scanner;

public class Kha02 {
    public static void main(String[] args) {
        Scanner kha02 = new Scanner(System.in);

        System.out.println("Hay nhap ma khu vuc (A, B, C, D): ");
        String text = kha02.nextLine();

        switch (text) {
            case "A": {
                System.out.println("Tầng 1: Sách Văn học");
                break;
            }
            case "B": {
                System.out.println("Tầng 2: Sách Khoa học");
                break;
            }
            case "C": {
                System.out.println("Tầng 3: Sách Ngoại ngữ");
                break;
            }
            case "D": {
                System.out.println("Tầng 4: Sách Tin học");
                break;
            }
            default: {
                System.out.println("Khong hop le, hay nhap lai");
            }
        }
    }
}
