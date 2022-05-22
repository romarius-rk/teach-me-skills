package hometask.lesson10;

import hometask.lesson10.model.Director;
import hometask.lesson10.model.Employee;
import hometask.lesson10.model.EmployeeType;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private Employee founded = null;
    private List<Employee> used = new ArrayList<>();

    public Employee dfs(Director director, String name, String lastName) {
        recursiveLookup(used, director, name, lastName);
        return founded;
    }

    private void recursiveLookup(List<Employee> used, Director director, String name, String lastName) {
        used.add(director);
        for (Employee employee : director.getEmployeeList()) {
            if (employee.getName().equals(name) && employee.getLastName().equals(lastName)) {
                founded = employee;
                break;
            }
            if (employee.getEmpType() == EmployeeType.DIRECTOR && !used.contains(employee)) {
                recursiveLookup(used, (Director) employee, name, lastName);
            }
        }
    }
}
