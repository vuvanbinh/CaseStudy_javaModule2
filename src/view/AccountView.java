package view;

import controller.AccountManager;
import model.Employee;
import stogera.FileEmployee;

import java.util.List;

public class AccountView {
    private  List<Employee> accountList = FileEmployee.readFile("account.txt");
    private  AccountManager accountManager = new AccountManager(accountList);
    private Validate validate = new Validate();

    public  Employee newAccount() {
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

        Employee account = new Employee(name, id, age, address, phoneNumber, status, useName, password);
        return account;
    }

    public  void addAccount(){
        Employee employee = newAccount();
        accountManager.add(employee);
    }
    public  void deleteAccount(){
        System.out.println("Nhap useName tai khoan muon xoa ");
        String useName = checkUseName();
        accountManager.delete(useName);
    }

    public String checkInputId(){
        while (true) {
            System.out.println("Nhap id :");
            String id = validate.checkEmpty();
            if(accountManager.getIndexOfId(id)==-1) return id;
            else System.out.println("Id da ton tai moi nhap lai. ");
        }
    }
    public String checkInputUseName(){
        while (true) {
            System.out.println("Nhap useName :");
            String useName = validate.checkEmpty();
            if(accountManager.getIndexOfUseName(useName)==-1) return useName;
            else System.out.println("useName da ton tai moi nhap lai. ");
        }
    }
     public String checkUseName(){
        while (true) {
            System.out.println("Nhap useName :");
            String useName = validate.checkEmpty();
            if(accountManager.getIndexOfUseName(useName)!=-1) return useName;
            else System.out.println("useName khong ton tai moi nhap lai. ");
        }
    }

    public void showAccount(String useName,int password){
        List<Employee> accountList = accountManager.getAccountList();
        for (Employee o: accountList
             ) {
            if(o.getUseName().equals(useName)&&o.getPassword() == password){
                System.out.println( "Thong tin tai khoan : \n "+ o);
            }
        }
    }
    public void showAccountList(){
        List<Employee> accountList = accountManager.getAccountList();
        for (Employee o: accountList
        ) {
            System.out.println(o);
        }
    }
    public boolean checkLogin(String useName,int password){
        List<Employee> accountList = accountManager.getAccountList();
        for (Employee o: accountList
        ) {
            if(o.getUseName().equals(useName)&&o.getPassword() == password) {
                return true;
            }
        }
        return false;
    }

    public void adminMenu(){
        int choice = -1;
        while (choice!=0){
            System.out.println("An 1 de them tai khoan dang nhap quan ly nhan vien. " +
                    "\nAn 2 de xoa tai khoan dang nhap quan ly nhan vien. " +
                    "\nAn 3 de hien thi thong tin cac tai khoan dang nhap quan ly nhan vien" +
                    "\nAn 0 de thoat.");
            choice = validate.inputInteger();
            switch (choice){
                case 1 :
                    System.out.println("Nhap thong tin tai khoan :");
                    addAccount();
                    break;
                case 2 :
                    deleteAccount();
                    break;
                case 3 :
                    System.out.println("Danh sach thong tin tai khoan dang nhap quan ly:");
                    showAccountList();
                    break;
            }
        }
    }
}
