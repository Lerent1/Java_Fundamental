package HN_KS24_CNTT4_NguyenTuanMinh_02.ra.business;

import HN_KS24_CNTT4_NguyenTuanMinh_02.ra.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeBusiness {
    protected static EmployeeBusiness instance;
    protected static List<Employee> employee;

    protected EmployeeBusiness() {
        employee = new ArrayList<>();
    }

    protected static EmployeeBusiness getInstance() {
        if (instance == null) {
            instance = new EmployeeBusiness();
        }
        return instance;
    }

    protected static List<Employee> getEmployee() {
        return employee;
    }

}
