package Session03.Bai04;

public class Gioi02 {
    public static void main(String[] args) {
        int[] books = {105, 102, 109, 101, 103};
        System.out.print("Danh sach truoc khi sap xep: ");
        for (int i = 0; i < books.length; i++) {
            System.out.print(books[i]);
            if (i < books.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - 1 - i; j++) {
                if (books[j] > books[j + 1]) {
                    int temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }

        System.out.print("Danh sach sau khi sap xep: ");
        for (int i = 0; i < books.length; i++) {
            System.out.print(books[i]);
            if (i < books.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
