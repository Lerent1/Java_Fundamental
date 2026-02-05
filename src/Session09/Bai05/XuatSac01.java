package Session09.Bai05;

import java.util.ArrayList;

public class XuatSac01 {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new OfficeEmployee("Nguyen Van A", 8000000, 2000000));
        employees.add(new Production("Tran Thi B", 500, 15000));
        employees.add(new OfficeEmployee("Le Van C", 9000000, 2500000));

        double totalSalary = 0;

        System.out.println("Danh sach: ");
        for (Employee e : employees) {
            e.display();
            totalSalary += e.calculateSalary();
        }

        System.out.println("Tong luong tat ca nhan vien: " + totalSalary);
    }
}
