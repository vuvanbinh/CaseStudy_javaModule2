package model;

public class FullTime extends Employee {
    private int salary;
    private int bonus;
    private int fine;

    public FullTime() {
    }

    public FullTime(int salary, int bonus, int fine) {
        this.salary = salary;
        this.bonus = bonus;
        this.fine = fine;
    }

    public FullTime(String name, String id, int age, String address, int phoneNumber, String status,
                    String useName, int password, int salary, int bonus, int fine) {
        super(name, id, age, address, phoneNumber, status, useName, password);
        this.salary = salary;
        this.bonus = bonus;
        this.fine = fine;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return  super.toString() + " ,FullTime{" +
                "salary: " + salary +
                ", bonus: " + bonus +
                ", fine: " + fine +
                '}';
    }

    @Override
    public int calculationSalary() {
        return salary+bonus-fine;
    }
}
