package Session09.Bai03;

public class Manager extends Employee {
    private String department;

    public Manager(String name, double basicSalary, String department) {
        super(name, basicSalary);
        this.department = department;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Phong ban: " + department);
    }
}
