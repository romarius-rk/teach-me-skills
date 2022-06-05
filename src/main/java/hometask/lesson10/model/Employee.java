package hometask.lesson10.model;

import java.util.Objects;

public abstract class Employee {
    protected String name;
    protected String lastName;
    protected double experience;
    protected EmployeeType empType;

    public Employee(String name, String lastName, double experience) {
        this.name = name;
        this.lastName = lastName;
        this.experience = experience;
    }

    public abstract double calculateSalary(double baseSalary);

    @Override
    public String toString() {
        return String.format("Employee name is %s %s - %s\n" +
                "Working experience is %f\n", name, lastName, empType.getTitle(), experience);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) && lastName.equals(employee.lastName);
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeType getEmpType() {
        return empType;
    }
}
