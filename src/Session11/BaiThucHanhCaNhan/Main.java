package Session11.BaiThucHanhCaNhan;

public class Main {
    public static void main(String[] args) {
        Drink[] drinks = new Drink[3];
        Coffee caphesua = new Coffee(1, "Bac xiu", 30000, true);
        FruitJuice nuoccam = new FruitJuice(2, "Nuoc cam", 40000, 10);

        drinks[0] = caphesua;
        drinks[1] = nuoccam;
        drinks[2] = null;

        for (int i = 0; i < drinks.length; i++) {
            if (drinks[i] != null) {
                System.out.println("Thong tin do uong " + (i + 1) + ":");
                drinks[i].displayInfo();
                System.out.println("Gia sau khi tinh: " + drinks[i].calculatePrice());
                System.out.println();
            }
        }
    }
}
