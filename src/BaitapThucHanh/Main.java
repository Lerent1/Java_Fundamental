package BaitapThucHanh;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hay nhap thong tin chim: ");
        Bird bird = new Bird();
        bird.input();
        System.out.println("\nThong tin chim la: ");
        bird.display();

        System.out.println("\nHay nhap thong ti dong vat: ");
        MamalAnimal mamal = new MamalAnimal();
        mamal.input();
        System.out.println("\nThong tin dong vat la: ");
        mamal.display();
    }
}
