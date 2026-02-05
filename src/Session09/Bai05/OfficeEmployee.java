package Session09.Bai05;

public class OfficeEmployee extends Employee {
    private double basicSalary;
    private double allowance;

    public OfficeEmployee(String name, double basicSalary, double allowance) {
        super(name);
        this.basicSalary = basicSalary;
        this.allowance = allowance;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + allowance;
    }
}
