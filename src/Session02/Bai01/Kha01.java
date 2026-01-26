package Session02.Bai01;

import java.util.Scanner;

public class Kha01 {
    public static void main(String[] args) {
        Scanner kha01 = new Scanner(System.in);

        System.out.println("Hay nhap tuoi: ");
        int age = kha01.nextInt();
        System.out.println("Hay nhap so sach dang giu: ");
        int books = kha01.nextInt();

        if (age < 18) {
            System.out.println("Ban chua du tuoi");
        } else if (books > 3){
            System.out.println("Ban da muon qua so luong cho phep");
        } else {
            System.out.println("Cho phep muon sach");
        }
    }
}
