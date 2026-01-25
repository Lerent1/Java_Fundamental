package Session01;

public class Gioi01 {
    public static void main(String[] args) {
        String book1 = "Java Basic";
        String book2 = "Python Intro";
        String temp;
        temp = book1;
        book1 = book2;
        book2 = temp;

        System.out.println("book1 = " + book1);
        System.out.println("book2 = " + book2);
    }
}