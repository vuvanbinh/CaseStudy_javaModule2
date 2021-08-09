package view;

import controller.EmployeeManager;
import model.Employee;
import model.FullTime;
import model.PartTime;
import stogera.FileEmployee;

import java.util.List;

public class EmployeeView {
    private List<Employee> employeeList = FileEmployee.readFile("employee.txt");
    private EmployeeManager binh = new EmployeeManager("Binh", employeeList);
    private Validate validate = new Validate();

    public Employee newFullTime() {
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
        String useName = checkInputUseName();
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

    public Employee newPartTime() {
        System.out.println("Nhap name : ");
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
        String useName = checkInputUseName();
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

    public void addEmployee() {
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

    public void editEmployee() {
        List<Employee> employeeList = binh.getEmployeeList();
        System.out.println("Nhap id cua nhan vien can chinh sua : ");
        String id = checkHaveId();
        int index = binh.getIndexOfId(id);
        if (employeeList.get(index).getStatus() == null) {
            System.out.println("An 1 de sua thanh nhan vien FullTime :");
            System.out.println("An 2 de sua thanh nhan vien PartTime :");
            int choice = validate.inputInteger();
            switch (choice) {
                case 1:
                    System.out.println("Nhap cac thong tin : ");
                    binh.edit(id,newFullTime());
                    break;
                case 2:
                    System.out.println("Nhap cac thong tin : ");
                    binh.edit(id,newPartTime());
                    break;
            }
        } else if (employeeList.get(index) instanceof FullTime) {
            binh.edit(id, newFullTime());
        } else binh.edit(id, newPartTime());
    }

    public void deleteEmployee() {
        System.out.println(" Nhap id nhan vien muon xoa : ");
        String id = checkHaveId();
        binh.delete(id);
    }

    public void showEmployee() {
        for (Employee o : binh.getEmployeeList()
        ) {
            System.out.println(o);
        }
    }

    public void findByName() {
        System.out.println("Nhap ten can tim kiem : ");
        String name = checkHaveName();
        for (Employee o : binh.findByName(name)
        ) {
            System.out.println(o);
        }
    }

    public void calculationSalaryEmployee() {
        System.out.println("Nhap id cua nhan vien muon tinh luong : ");
        String id = checkHaveId();
        int salary = binh.calculationSalary(id);
        System.out.println("Luong cua nhan vien co id : " + id + "la = " + salary);
    }

    public void showEmployeeStatus(String status) {
        for (Employee o : binh.getEmployeeStatus(status)
        ) {
            System.out.println(o);
        }
    }

    public void showClassifyEmployee(String classifyEmployee) {
        for (Employee o : binh.getClassifyEmployee(classifyEmployee)
        ) {
            System.out.println(o);
        }
    }

    public void updateStatus() {
        System.out.println("Nhap id cua nhan vien muon cap nhat trang thai : ");
        String id = checkHaveId();
        binh.updateStatus(id);
    }

    public void checkStatus() {
        System.out.println("Nhap ten can kiem tra trang thai : ");
        String name = checkHaveName();
        List<Employee> employeeList = binh.findByName(name);
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println("Nhan vien : " + name + ", " +
                    "co id : " + employeeList.get(i).getId() + ", Trang thai : "
                    + employeeList.get(i).getStatus());
        }
    }

    public String checkHaveId() {
        while (true) {
            System.out.println("Nhap id");
            String id = validate.checkEmpty();
            if (binh.getIndexOfId(id) != -1) {
                return id;
            } else System.out.println("id nhap vao khong co trong danh sach nhan vien, moi nhap lai. ");
        }
    }

    public String checkHaveName() {
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

    public String checkInputId() {
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

    public String checkInputUseName() {
        while (true) {
            System.out.println("Nhap UseName");
            String useName = validate.checkEmpty();
            if (binh.getIndexOfUseName(useName) == -1) {
                return useName;
            } else {
                System.out.println("UseName da ton tai, moi nhap lai.");
            }
        }
    }

    public boolean checkLogin(String useName, int password) {
        if (binh.getIndexOfUseNamePassword(useName, password) != -1) return true;
        else return false;
    }

    public void choiceShow() {
        int choice = -1;
        while (choice != 0) {
            System.out.println(" An 1 hien thi danh sach toan bo cac nhan vien. \n An 2 de xem luong." +
                    "\n An 3 hien thi nhan vien FullTime. \n An 4 hien thi danh sach nhan vien PartTime." +
                    " \n An 5 hien thi danh sach cac nhan vien dang lam. \n An 6 hien thi cac nhan vien da nghi." +
                    "\n An 0 de quay lai.");

            choice = validate.inputInteger();
            switch (choice) {
                case 1:
                    System.out.println("Danh sach cac nhan vien :");
                    showEmployee();
                    break;
                case 2:
                    calculationSalaryEmployee();
                    break;
                case 3:
                    System.out.println("Danh sach cac nhan vien FullTime :");
                    String classifyFullTime = "fullTime";
                    showClassifyEmployee(classifyFullTime);
                    break;
                case 4:
                    System.out.println("Danh sach cac nhan vien PartTime :");
                    String classifyPartTime = "partTime";
                    showClassifyEmployee(classifyPartTime);
                    break;
                case 5:
                    System.out.println("Danh sach nhan vien dang lam :");
                    String statusDoing = "dang lam";
                    showEmployeeStatus(statusDoing);
                    break;
                case 6:
                    System.out.println("Danh sach nhan vien da nghi :");
                    String statusNotDoing = "da nghi";
                    showEmployeeStatus(statusNotDoing);
                    break;
            }
        }
    }

    public void showEmployee(String useName, int password) {
        int index = binh.getIndexOfUseNamePassword(useName, password);
        if (index != -1) {
            Employee employee = binh.getEmployeeList().get(index);
            System.out.println(employee + "\n Luong thu nhap : " + employee.calculationSalary());
            if (employee.getStatus().equals("Chua nhan viec")) {
                System.out.println("Ban dang la thanh vien moi, hay dang ky lam FullTime" +
                        " hoac PartTime voi quan ly \n");
            }
        }
    }

    public void employeeMenu(String useName, int password) {
        int choice = -1;
        while (choice != 0) {
            System.out.println("An 1 de xem thong tin cua ban. \nAn 0 de thoat. ");
            choice = validate.inputInteger();
            if (choice == 1) {
                showEmployee(useName, password);
            }
        }
    }

    public Employee newMember() {
        System.out.println("Nhap name :  ");
        String name = validate.checkEmpty();
        String id = checkInputId();
        System.out.println("Nhap age : ");
        int age = validate.inputInteger();
        System.out.println("Nhap  address : ");
        String address = validate.checkEmpty();
        System.out.println("Nhap Phone Number : ");
        int phoneNumber = validate.inputInteger();
        String status = "Chua nhan viec";
        String useName = checkInputUseName();
        System.out.println("Nhap password : ");
        int password = validate.inputInteger();

        Employee member = new Employee(name, id, age, address, phoneNumber, status,
                useName, password);
        return member;
    }

    public void addNewMember() {


        binh.add(newMember());
    }

}
