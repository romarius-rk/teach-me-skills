package hometask.lesson10;

import hometask.lesson10.model.Director;
import hometask.lesson10.model.Worker;

public class Runner {
    public static void main(String... args) {

        EmployeeService employeeService = new EmployeeService();

        Director director1 = new Director("Ilya", "Kireev", 3.25);
        Director director2 = new Director("Marina", "Serpilina", 3.8);
        Director director3 = new Director("Marinad", "Serpilina", 3.8);
        Worker worker1 = new Worker("Roma", "Karpuzovich", 1.125);
        Worker worker2 = new Worker("Alex", "Orlov", 0.38);
        Worker worker3 = new Worker("Dmitry", "Stecki", 10.3);
        Worker worker4 = new Worker("Dmitry", "Bolohov", 10.3);

        director1.addEmployees(worker1, worker3);

        director2.addEmployees(worker2);

        director3.addEmployees(worker4);

        director1.addEmployees(director2, director3);

//        director1.printSubordinateEmpInfo();

        System.out.println(employeeService.dfs(director1, "Alex", "Orlov"));

    }
}
