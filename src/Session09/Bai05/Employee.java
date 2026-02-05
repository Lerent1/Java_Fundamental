package Session09.Bai05;

public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    // Phương thức tính lương (đa hình)
    public double calculateSalary() {
        return 0;
    }

    public void display() {
        System.out.println("Nhan vien: " + name);
        System.out.println("Luong: " + calculateSalary());
    }
}
