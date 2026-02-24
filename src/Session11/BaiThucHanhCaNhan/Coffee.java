package Session11.BaiThucHanhCaNhan;

public class Coffee extends Drink {
    private boolean hasMilk;

    public Coffee(int id, String name, double price, boolean hasMilk) {
        super(id, name, price);
        this.hasMilk = hasMilk;
    }

    @Override
    public double calculatePrice() {
        if(hasMilk) {
            return price + 500;
        }
        return price;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        if(hasMilk) {
            System.out.println("Co sua");
        } else {
            System.out.println("Den da");
        }
    }
}
