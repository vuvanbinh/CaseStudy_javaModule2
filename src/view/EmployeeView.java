package view;

import controller.EmployeeManager;
import model.Employee;
import model.FullTime;
import model.PartTime;
import stogera.FileEmployee;

import java.util.List;
import java.util.Scanner;

public class EmployeeView {
    private List<Employee> employeeList = FileEmployee.readFile("employee.txt");
    private EmployeeManager binh = new EmployeeManager("Binh", employeeList);
    private Validate validate = new Validate();


    public  Employee newFullTime() {
        System.out.println("Nhap name :  ");
        String name = validate.checkEmpty();
        String id = checkInputId();
        System.out.println("Nhap age : ");
        int age = validate.inputInteger();
        System.out.println("Nhap  address : ");
        String address = validate.checkEmpty();
        System.out.println("Nhap Phone Number : ");
        int phoneNumber = validate.inputInteger();
        System.out.println("Nhap status : ");
        String status = validate.checkEmpty();
        System.out.println("Nhap useName : ");
        String useName = validate.checkEmpty();
        System.out.println("Nhap password : ");
        int password = validate.inputInteger();
        System.out.println("Nhap salary : ");
        int salary = validate.inputInteger();
        System.out.println("Nhap bonus : ");
        int bonus = validate.inputInteger();
        System.out.println("Nhap fine : ");
        int fine = validate.inputInteger();

        Employee newFullTime = new FullTime(name, id, age, address, phoneNumber, status,
                useName, password, salary, bonus, fine);
        return newFullTime;
    }

    public  Employee newPartTime() {
        System.out.println("Nhap name :  ");
        String name = validate.checkEmpty();
        String id = checkInputId();
        System.out.println("Nhap age : ");
        int age = validate.inputInteger();
        System.out.println("Nhap  address : ");
        String address = validate.checkEmpty();
        System.out.println("Nhap Phone Number : ");
        int phoneNumber = validate.inputInteger();
        System.out.println("Nhap status : ");
        String status = validate.checkEmpty();
        System.out.println("Nhap useName : ");
        String useName = validate.checkEmpty();
        System.out.println("Nhap password : ");
        int password = validate.inputInteger();
        System.out.println("Nhap salaryTime : ");
        int salaryTime = validate.inputInteger();
        System.out.println("Nhap wordTime : ");
        int wordTime = validate.inputInteger();

        Employee newPartTime = new PartTime(name, id, age, address, phoneNumber, status,
                useName, password, salaryTime, wordTime);
        return newPartTime;
    }

    public  void addEmployee() {
        System.out.println("Nhap so nhan vien muon them vao : ");
        int number = validate.inputInteger();
        int i = 0;
        while (i < number) {
            System.out.println("An 1 de them nhan vien FullTime :");
            System.out.println("An 2 de them nhan vien PartTime :");
            int choice = validate.inputInteger();
            switch (choice) {
                case 1:
                    System.out.println("Nhap thong tin nhan vien " + (i + 1));
                    binh.add(newFullTime());
                    break;
                case 2:
                    System.out.println("Nhap thong tin nhan vien " + (i + 1));
                    binh.add(newPartTime());
                    break;
            }
            i++;
        }

    }

    public  void editEmployee() {
        System.out.println("Nhap id cua nhan vien can chinh sua : ");
        String id = checkId();
        int index = binh.getIndexOfId(id);
        List<Employee> employees = binh.getEmployeeList();
        if (employees.get(index) instanceof FullTime) {
            employees.set(index, newFullTime());
        } else employees.set(index, newPartTime());
    }

    public  void deleteEmployee() {
        System.out.println(" Nhap id nhan vien muon xoa : ");
        String id = checkId();
        binh.delete(id);
    }

    public  void showEmployee() {
        for (Employee o : binh.getEmployeeList()
        ) {
            System.out.println(o);
        }
    }

    public  void findByName() {
        System.out.println("Nhap ten can tim kiem : ");
        String name = checkName();
        for (Employee o : binh.findByName(name)
        ) {
            System.out.println(o);
        }
    }

    public  void showEmployeeDoing() {
        for (Employee o : binh.EmployDoing()
        ) {
            System.out.println(o);
        }
    }

    public  void showEmployeeNotDoing() {
        for (Employee o : binh.EmployNotDoing()
        ) {
            System.out.println(o);
        }
    }

    public  void showFullTime(){
        for (Employee o : binh.classifyFullTime()
        ) {
            System.out.println(o);
        }
    }

    public  void showPartTime(){
        for (Employee o : binh.classifyPartTime()
        ) {
            System.out.println(o);
        }
    }

    public  void updateStatus() {
        System.out.println("Nhap id cua nhan vien muon cap nhat trang thai : ");
        String id = checkId();
        binh.updateStatus(id);
    }

    public  void checkStatus() {
        System.out.println("Nhap ten can kiem tra trang thai : ");
        String name = checkName();
        List<Employee> employeeList = binh.findByName(name);
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println("Nhan vien : " + name + ", " +
                    "co id : " + employeeList.get(i).getId() + ", Trang thai : "
                    + employeeList.get(i).getStatus());
        }
    }

    public  String checkId() {
        while (true) {
            System.out.println("Nhap id");
            String id = validate.checkEmpty();
            if (binh.getIndexOfId(id) != -1) {
                return id;
            } else System.out.println("id nhap vao khong co trong danh sach nhan vien, moi nhap lai. ");
        }
    }

    public  String checkName() {
        while (true) {
            System.out.println("Nhap ten : ");
            String name = validate.checkEmpty();
            for (Employee o : binh.getEmployeeList()
            ) {
                if (o.getName().equals(name)) return name;
            }
            System.out.println("Ten vua nhap khong co trong danh sach, moi nhap lai :");
        }
    }

    public  String checkInputId() {
        while (true) {
            System.out.println(" nhap id : ");
            String id = validate.checkEmpty();
            if (binh.getIndexOfId(id) == -1) {
                return id;
            } else {
                System.out.println("id da co trong danh sach, moi nhap lai :");
            }
        }
    }

    public  void choiceShow(){
        System.out.println(" An 1 hien thi danh sach toan bo cac nhan vien.\n An 2 hien thi nhan vien FullTime." +
                "\n An 3 hien thi danh sach nhan vien PartTime. \n An 4 hien thi danh sach cac nhan vien dang lam." +
                "\n An 5 hien thi cac nhan vien da nghi");
        int choice = validate.inputInteger();
        switch (choice){
            case 1 :
                System.out.println("Danh sach cac nhan vien :");
                showEmployee();
                break;
            case 2 :
                System.out.println("Danh sach cac nhan vien FullTime :");
                showFullTime();
                break;
            case 3 :
                System.out.println("Danh sach cac nhan vien PartTime :");
                showPartTime();
                break;
            case 4 :
                System.out.println("Danh sach nhan vien dang lam :");
                showEmployeeDoing();
                break;
            case 5 :
                System.out.println("Danh sach nhan vien da nghi :");
                showEmployeeNotDoing();
                break;
        }
    }
}
