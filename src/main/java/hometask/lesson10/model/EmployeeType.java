package hometask.lesson10.model;

public enum EmployeeType {
    DIRECTOR(1.35, "director"),
    WORKER(1.12, "worker");

    private double coefficient;
    private String title;

    EmployeeType(double coefficient, String title) {
        this.coefficient = coefficient;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public double getCoefficient() {
        return coefficient;
    }
}
