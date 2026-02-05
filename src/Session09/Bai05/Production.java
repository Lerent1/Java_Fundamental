package Session09.Bai05;

public class Production extends Employee {
    private int productCount;
    private double salaryPerProduct;

    public Production(String name, int productCount, double salaryPerProduct) {
        super(name);
        this.productCount = productCount;
        this.salaryPerProduct = salaryPerProduct;
    }

    @Override
    public double calculateSalary() {
        return productCount * salaryPerProduct;
    }
}
