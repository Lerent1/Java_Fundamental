package Session10.Bai02;

abstract class Vehicle {
    protected String brand;
    public Vehicle(String brand) {
        this.brand = brand;
    }

    public abstract void move();
}

class Car extends Vehicle {
    public Car(String brand) {
        super(brand);
    }

    @Override
    public void move() {
        System.out.println(brand + " - Cach di chuyen: Di chuyen bang dong co");
    }
}

class Bicycle extends Vehicle {
    public Bicycle(String brand) {
        super(brand);
    }

    @Override
    public void move() {
        System.out.println(brand + " - Cach di chuyen: Di chuyen bang suc nguoi");
    }
}


public class Kha02 {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota");
        Vehicle bicycle = new Bicycle("Giant");
        car.move();
        bicycle.move();
    }
}
