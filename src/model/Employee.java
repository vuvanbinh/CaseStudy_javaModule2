package model;

import java.io.Serializable;

public class Employee implements EmployeeInterface, Serializable {
    private String name;
    private String id;
    private int age;
    private String address;
    private int phoneNumber;
    private String status;
    private String useName;
    private int password;

    public Employee() {
    }

    public Employee(String name, String id, int age, String address, int phoneNumber, String useName, int password) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.useName = useName;
        this.password = password;
    }

    public Employee(String name, String id, int age, String address, int phoneNumber,
                    String status, String useName, int password) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.useName = useName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
       if(status == null){
           return "Employee{" +
                   "name: '" + name + '\'' +
                   ", id: '" + id + '\'' +
                   ", age: " + age +
                   ", address: '" + address + '\'' +
                   ", phoneNumber: " + phoneNumber +
                   ", status: Chua nhan viec " +
                   ", useName: '" + useName + '\'' +
                   ", password: " + password +
                   '}';
       }else  return "Employee{" +
               "name: '" + name + '\'' +
               ", id: '" + id + '\'' +
               ", age: " + age +
               ", address: '" + address + '\'' +
               ", phoneNumber: " + phoneNumber +
               ", status: " + status +
               ", useName: '" + useName + '\'' +
               ", password: " + password +
               '}';
    }

    @Override
    public int calculationSalary() {
        return 0;
    }
}
