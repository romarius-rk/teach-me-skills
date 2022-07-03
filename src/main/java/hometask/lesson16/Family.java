package hometask.lesson16;

import java.util.List;

public class Family {

    protected String lastName;
    protected String adres;
    protected Double averageSalary;
    protected List<Child> children;

    @Override
    public String toString() {
        return "Family{" +
                "lastName='" + lastName + '\'' +
                ", adres='" + adres + '\'' +
                ", averageSalary=" + averageSalary +
                ", children=" + children +
                '}';
    }

    public Family(String lastName, String adres, List<Parent> parents, List<Child> children) {
        this.lastName = lastName;
        this.adres = adres;
        this.averageSalary = (parents.get(0).salary + parents.get(1).salary)/parents.size();
        this.children = children;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(Double averageSalary) {
        this.averageSalary = averageSalary;
    }
}
