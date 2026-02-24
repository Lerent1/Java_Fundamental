package Session11.BaiThucHanhCaNhan;

public abstract class Drink {
    protected int id;
    protected String name;
    protected double price;

    public Drink(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public abstract double calculatePrice();

    public void displayInfo() {
        System.out.println("Ma: " + id);
        System.out.println("Ten: " + name);
        System.out.println("Gia: " + price);
    }
}
