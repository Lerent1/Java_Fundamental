package Session04.Bai01;

import java.util.Scanner;

public class Kha01 {
    public static void main(String[] args) {
        Scanner kha01 = new Scanner(System.in);

        System.out.print("Hay nhap ten sach: ");
        String book = kha01.nextLine();

        System.out.print("Hay nhap ten tac gia: ");
        String author = kha01.nextLine();

        book = book.trim().replaceAll("\\s+", " ");
        author = author.trim().replaceAll("\\s+", " ");

        book = book.toUpperCase();

        String[] words = author.toLowerCase().split(" ");
        String aauthor = "";

        for (int i = 0; i < words.length; i++) {
            aauthor += words[i].substring(0, 1).toUpperCase()
                    + words[i].substring(1) + " ";
        }
        aauthor = aauthor.trim();

        System.out.println(book + " - Tac gia: " + aauthor);
    }
}
