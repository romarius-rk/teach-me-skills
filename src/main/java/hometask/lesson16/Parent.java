package hometask.lesson16;

public class Parent extends Human{

    protected Double salary;

    public Parent(String name, String sex, Integer age, Double salary){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
