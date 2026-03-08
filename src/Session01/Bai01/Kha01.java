package Session01.Bai01;

import java.util.Scanner;

public class Kha01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Hay nhap nam sinh cua ban: ");
            String input = sc.nextLine();

            int birthYear = Integer.parseInt(input);
            int age = 2026 - birthYear;

            System.out.println("Tuoi cua ban la: " + age);
        }
        catch (NumberFormatException e) {
            System.out.println("Loi: Ban phai nhap nam sinh bang so");
        }
        finally {
            sc.close();
            System.out.println("Thuc hien don dep tai nguyen trong finally...");
        }
    }
}
