package HN_KS24_CNTT04_NguyenTuanMinh_02.Cau01;

import java.util.Scanner;

public class Phan01 {
    public static String upperCase(String up) {
        return up.substring(0, 1).toUpperCase() + up.substring(1).toLowerCase() + " ";
    }

    public static void main(String[] args) {
        Scanner check = new Scanner(System.in);

        System.out.println("Hay nhap chuoi muon sua: ");
        String input = check.nextLine();
        if (input.length() <= 0) {
            System.out.println("Khong nhap noi dung");
        }

        String result = "";
        String word = "";
        for(int i = 0; i < input.length(); i++){
            char text = input.charAt(i);
            if (text >= 'a' && text <= 'z' || text >= 'A' && text <= 'Z' || text == ' ') {
                word += text;
            }
        }

        if (!word.isEmpty()) {
            result += upperCase(word);
        }
        System.out.println(result.trim());
    }
}
