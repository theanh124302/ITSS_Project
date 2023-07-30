package project.itss.group11.itss.repository;

import project.itss.group11.itss.model.Employee;

import java.util.List;

public interface EmployeeInforRepository {
    List<Employee> getEmployeeInfor(String query);
    Employee getInforUser(int id);

}
