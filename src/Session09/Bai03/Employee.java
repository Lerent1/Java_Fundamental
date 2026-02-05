package Session09.Bai03;

public class Employee {
    protected String name;
    protected double basicSalary;

    public Employee(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public void display() {
        System.out.println("Ten nhan vien: " + name);
        System.out.println("Luong co ban: " + basicSalary);
    }
}
