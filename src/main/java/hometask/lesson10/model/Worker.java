package hometask.lesson10.model;

public class Worker extends Employee {

    public Worker(String name, String lastName, double experience) {
        super(name, lastName, experience);
        empType = EmployeeType.WORKER;
    }

    @Override
    public double calculateSalary(double baseSalary) {
        return baseSalary * (1 + this.experience / 15) * this.empType.getCoefficient();
    }
}
