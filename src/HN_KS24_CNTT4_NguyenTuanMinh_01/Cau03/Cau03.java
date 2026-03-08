package HN_KS24_CNTT4_NguyenTuanMinh_01.Cau03;

import java.util.Scanner;
import java.util.Stack;

public class Cau03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> list = new Stack<>();

        System.out.print("Hay Nhap vao mot so nguyen duong bat ky: ");
        int num = sc.nextInt();
        if(num < 0) {
            System.out.println("Khong duoc nhap so am");
            return;
        }

        while(num > 0) {
            list.push(num % 2);
            num = num / 2;
        }

        System.out.print("So nhi phan la: ");
        while (!list.isEmpty()) {
            System.out.print(list.pop());
        }
    }
}
