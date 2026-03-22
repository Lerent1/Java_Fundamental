package HN_KS24_CNTT4_NguyenTuanMinh_02.ra.entity;

import java.util.Scanner;

public class Employee {
    protected String empId;
    protected String empName;
    protected int age;
    protected double salary;

    public Employee() {
    }

    public Employee(String empId, String empName, int age, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.age = age;
        this.salary = salary;
    }

    public String getEmpId() {
        return empId;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void inputData(Scanner scanner) {
        System.out.println("Hay nhap id cua nhan vien: ");
        empId = scanner.next();
        if(empId.isEmpty()){
            System.out.println("Id da ton tai");
        }
        System.out.println("Hay nhap name cua nhan vien: ");
        empName = scanner.next();
        System.out.println("Hay nhap tuoi cua nhan vien: ");
        age = scanner.nextInt();
        System.out.println("Hay nhap luong cua nhan vien: ");
        salary = scanner.nextDouble();
    }

    public void displayData() {
        System.out.println("ID: " + empId + ", Name: " + empName + ", Age: " + age + ", Salary: " + salary);
    }
}
