package model;

public class PartTime extends Employee {
    private int salaryTime;
    private int wordTime;

    public PartTime() {
    }

    public PartTime(int salaryTime, int wordTime) {
        this.salaryTime = salaryTime;
        this.wordTime = wordTime;
    }

    public PartTime(String name, String id, int age, String address, int phoneNumber, String status,
                    String useName, int password, int salaryTime, int wordTime) {
        super(name, id, age, address, phoneNumber, status, useName, password);
        this.salaryTime = salaryTime;
        this.wordTime = wordTime;
    }

    public int getSalaryTime() {
        return salaryTime;
    }

    public void setSalaryTime(int salaryTime) {
        this.salaryTime = salaryTime;
    }

    public int getWordTime() {
        return wordTime;
    }

    public void setWordTime(int wordTime) {
        this.wordTime = wordTime;
    }

    @Override
    public String toString() {
        return super.toString() + " PartTime{" +
                "salaryTime: " + salaryTime +
                ", wordTime: " + wordTime +
                '}';
    }

    @Override
    public int payroll() {
        return salaryTime*wordTime;
    }
}
