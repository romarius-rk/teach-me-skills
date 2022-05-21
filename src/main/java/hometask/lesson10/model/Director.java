package hometask.lesson10.model;

import java.util.ArrayList;
import java.util.List;

public class Director extends Employee {

    private final List<Employee> employeeList = new ArrayList<>();

    public Director(String name, String lastName, double experience) {
        super(name, lastName, experience);
        empType = EmployeeType.DIRECTOR;
    }

    public void addEmployees(Employee... employees) {
        employeeList.addAll(List.of(employees));
    }

    @Override
    public double calculateSalary(double baseSalary) {
        return baseSalary * (1 + this.experience / 10) * this.empType.getCoefficient() * calculateSalaryCoefByStaff();
    }


    public void printSubordinateEmpInfo() {
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    private double calculateSalaryCoefByStaff() {
        return 1 + (double) employeeList.size() / 100;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
