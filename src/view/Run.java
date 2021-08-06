package view;

import model.Employee;

import java.util.Scanner;

public class Run {
    static EmployeeView employeeView = new EmployeeView();
    static AccountView accountView = new AccountView();
    static Validate validate = new Validate();

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("An 1 de dang nhap tai khoan. \nAn 2 de dang ky tai khoan moi. \nAn 0 de thoat. ");
            choice = validate.inputInteger();
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    System.out.println("Nhap cac thong tin sau :");
                    accountView.addAccount();
                    System.out.println("Dang ky tai khoan thanh cong, hay dang nhap");
                    break;
            }
        }
    }

    public static void menu(String useName, int password) {
        int choice = -1;
        while (choice != 8) {
            System.out.println("MENU :\n An 1 de them nhan vien." +
                    "\n An 2 de hien thi.\n An 3 de tim kiem nhan vien." +
                    "\n An 4 de kiem tra trang thai nhan vien. \n An 5 de sua thong tin nhan vien." +
                    "\n An 6 de thay doi trang thai nhan vien. \n An 7 xem thong tin tai khoan." +
                    "\n An 8 de dang xuat");
            choice = validate.inputInteger();
            switch (choice) {
                case 1:
                    employeeView.addEmployee();
                    break;
                case 2:
                    employeeView.choiceShow();
                    break;
                case 3:
                    employeeView.findByName();
                    break;
                case 4:
                    employeeView.checkStatus();
                    break;
                case 5:
                    employeeView.editEmployee();
                    break;
                case 6:
                    employeeView.updateStatus();
                    break;
                case 7:
                    accountView.showAccount(useName, password);
            }
        }
    }

    public static void login() {
        int i = 0;
        while (i < 3) {
            System.out.println("Nhap useName : ");
            String useName = validate.checkEmpty();
            System.out.println("Nhap password : ");
            int passWord = validate.inputInteger();
            if (accountView.checkLogin(useName, passWord)) {
                menu(useName, passWord);
                break;
            } else if (useName.equals("admin") && passWord == 0000) {
                accountView.adminMenu();
                break;
            } else System.out.println("useName hoac passWord khong chinh xac lan "+(i+1));

            if(i==2) System.out.println("Ban da nhap sai qua 3 lan, he thong tu dong quay lai Menu");
            i++;
        }
    }
}


