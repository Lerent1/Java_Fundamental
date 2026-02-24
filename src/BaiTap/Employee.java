package BaiTap;

public abstract class Employee {
    protected String name;
    protected String baseSalary;

    public Employee(String name, String baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public String getBaseSalary() {
        return baseSalary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBaseSalary(String baseSalary) {
        this.baseSalary = baseSalary;
    }
}
