package view;

import controller.ManagerAccountController;
import model.Employee;
import stogera.FileEmployee;

import java.util.List;

public class ManagerAccountView {
    private List<Employee> employeeList = FileEmployee.readFile("employee.txt");
    private List<Employee> managerAccountList = FileEmployee.readFile("account.txt");
    private ManagerAccountController managerAccountController = new ManagerAccountController(managerAccountList);
    private Validate validate = new Validate();

    public Employee getEmployee(String useName, int password){
        Employee employee = new Employee() ;
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee1 = employeeList.get(i);
            if(employee1.getUseName().equals(useName)&&employee1.getPassword()==password){
                 employee = employee1;
                 break;
            }
        }
        return employee;
    }

    public Employee newManagerAccount() {
        String useName = checkInputUseName();
        System.out.println("Nhap password : ");
        int password = validate.inputInteger();
        Employee managerAccount = getEmployee(useName,password);
        return managerAccount;
    }

    public void addManagerAccount() {
        managerAccountController.add(newManagerAccount());
    }

    public void deleteManagerAccount() {
        System.out.println("Nhap useName tai khoan muon xoa ");
        String useName = checkUseName();
        managerAccountController.delete(useName);
    }

    public String checkInputId() {
        while (true) {
            System.out.println("Nhap id :");
            String id = validate.checkEmpty();
            if (managerAccountController.getIndexOfId(id) == -1) return id;
            else System.out.println("Id da ton tai moi nhap lai. ");
        }
    }

    public String checkInputUseName() {
        while (true) {
            System.out.println("Nhap useName :");
            String useName = validate.checkEmpty();
            if (managerAccountController.getIndexOfUseName(useName) == -1) return useName;
            else System.out.println("useName da ton tai moi nhap lai. ");
        }
    }

    public String checkUseName() {
        while (true) {
            System.out.println("Nhap useName :");
            String useName = validate.checkEmpty();
            if (managerAccountController.getIndexOfUseName(useName) != -1) return useName;
            else System.out.println("useName khong ton tai moi nhap lai. ");
        }
    }

    public void showManagerAccount(String useName, int password) {
        List<Employee> managerAccountList = managerAccountController.getManagerAccountList();
        for (Employee o : managerAccountList
        ) {
            if (o.getUseName().equals(useName) && o.getPassword() == password) {
                System.out.println("Thong tin tai khoan : \n " + o);
            }
        }
    }

    public void showManagerAccountList() {
        List<Employee> managerAccountList = managerAccountController.getManagerAccountList();
        for (Employee o : managerAccountList
        ) {
            System.out.println(o);
        }
    }

    public boolean checkLogin(String useName, int password) {
        List<Employee> managerAccountList = managerAccountController.getManagerAccountList();
        for (Employee o : managerAccountList
        ) {
            if (o.getUseName().equals(useName) && o.getPassword() == password) {
                return true;
            }
        }
        return false;
    }

    public void adminMenu() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("An 1 de them tai khoan dang nhap quan ly nhan vien. " +
                    "\nAn 2 de xoa tai khoan dang nhap quan ly nhan vien. " +
                    "\nAn 3 de hien thi thong tin cac tai khoan dang nhap quan ly nhan vien" +
                    "\nAn 0 de thoat.");
            choice = validate.inputInteger();
            switch (choice) {
                case 1:
                    System.out.println("Nhap thong tin tai khoan :");
                    addManagerAccount();
                    System.out.println("Them tai khoan dang nhap thanh cong");
                    break;
                case 2:
                    deleteManagerAccount();
                    break;
                case 3:
                    System.out.println("Danh sach thong tin tai khoan dang nhap quan ly:");
                    showManagerAccountList();
                    break;
            }
        }
    }
}
