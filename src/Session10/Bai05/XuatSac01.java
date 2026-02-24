package Session10.Bai05;

abstract class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();
    public void displayInfo() {
        System.out.println("Ten: " + name);
        System.out.println("Luong co ban: " + baseSalary);
    }
}

interface BonusCalculator {
    double getBonus();
}

class OfficeStaff extends Employee {

    public OfficeStaff(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}

class Manager extends Employee implements BonusCalculator {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double getBonus() {
        return bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + getBonus();
    }
}

public class XuatSac01 {
    public static void main(String[] args) {
        Employee staff = new OfficeStaff("Nguyen Van A", 8000000);
        Employee manager = new Manager("Tran Thi B", 15000000, 5000000);

        staff.displayInfo();
        System.out.println("Tong luong: " + staff.calculateSalary());
        System.out.println("-------------------------");

        manager.displayInfo();
        System.out.println("Thuong KPI: " + ((Manager) manager).getBonus());
        System.out.println("Tong luong: " + manager.calculateSalary());
    }
}
