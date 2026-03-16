package Session07.Bai02;

interface DiscountStrategy {
    double applyDiscount(double totalAmount);
}

class PercentageDiscount implements DiscountStrategy {
    double percent;
    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    public double applyDiscount(double totalAmount) {
        return totalAmount - (totalAmount * percent / 100);
    }
}

class FixedDiscount implements DiscountStrategy {
    double amount;
    public FixedDiscount(double amount) {
        this.amount = amount;
    }

    public double applyDiscount(double totalAmount) {
        return totalAmount - amount;
    }
}

class NoDiscount implements DiscountStrategy {
    public double applyDiscount(double totalAmount) {
        return totalAmount;
    }
}

class HolidayDiscount implements DiscountStrategy {
    public double applyDiscount(double totalAmount) {
        return totalAmount - (totalAmount * 15 / 100);
    }
}

class OrderCalculator {

    DiscountStrategy discountStrategy;

    public OrderCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculate(double totalAmount) {
        return discountStrategy.applyDiscount(totalAmount);
    }
}

public class Kha02 {
    public static void main(String[] args) {
        double total = 1000000;

        System.out.println("Don hang: tong tien 1.000.000, ap dung PercentageDiscount 10%");
        OrderCalculator calc1 = new OrderCalculator(new PercentageDiscount(10));
        System.out.println("So tien sau giam: " + (int) calc1.calculate(total));
        System.out.println();

        System.out.println("Don hang: tong tien 1.000.000, ap dung FixedDiscount 50.000");
        OrderCalculator calc2 = new OrderCalculator(new FixedDiscount(50000));
        System.out.println("So tien sau giam: " + (int) calc2.calculate(total));
        System.out.println();

        System.out.println("Don hang: tong tien 1.000.000, ap dung NoDiscount");
        OrderCalculator calc3 = new OrderCalculator(new NoDiscount());
        System.out.println("So tien sau giam: " + (int) calc3.calculate(total));
        System.out.println();

        System.out.println("Them HolidayDiscount 15% (khong sua code cu)");
        OrderCalculator calc4 = new OrderCalculator(new HolidayDiscount());
        System.out.println("So tien sau giam: " + (int) calc4.calculate(total));
    }
}
