package view;

public class Run {
    static EmployeeView employeeView = new EmployeeView();
    static ManagerAccountView managerAccountView = new ManagerAccountView();
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
                    employeeView.addNewMember();
                    System.out.println("Dang ky tai khoan thanh cong, hay dang nhap");
                    break;
            }
        }
    }

    public static boolean checkLoginAdmin(String useName, int password){
        if(useName.equals("admin") && password==1111) return true;
        else return false;
    }

    public static void login() {
        int i = 0;
        while (i < 3) {
            System.out.println("Nhap useName : ");
            String useName = validate.checkEmpty();
            System.out.println("Nhap password : ");
            int passWord = validate.inputInteger();

            if (checkLoginAdmin(useName,passWord)) {
                int choice = -1;
                while (choice != 0) {
                    System.out.println("An 1 de truy cap vao quan ly nhan vien." +
                            "\nAn 2 de truy cap vao quan ly cac tai khoan cua quan ly nhan vien." +
                            "\nAn 0 de quay lai man hinh dang nhap.");
                    choice = validate.inputInteger();
                    switch (choice) {
                        case 1:
                            employeeManagerMenu(useName, passWord);
                            break;
                        case 2:
                            managerAccountView.adminMenu();
                            break;
                    }
                }
                break;
            } else if (managerAccountView.checkLogin(useName, passWord)) {
                employeeManagerMenu(useName, passWord);
                break;
            } else if (employeeView.checkLogin(useName, passWord)) {
                employeeView.employeeMenu(useName, passWord);
                break;
            } else System.out.println("useName hoac passWord khong chinh xac lan " + (i + 1));

            if (i == 2) System.out.println("Ban da nhap sai qua 3 lan, he thong tu dong quay lai Menu");
            i++;
        }
    }

    public static void employeeManagerMenu(String useName, int password) {
        int choice = -1;
        while (choice != 9) {
            System.out.println("MENU :\n An 1 de them nhan vien. \n An 2 sua thong tin nhan vien." +
                    "\n An 3 de hien thi.\n An 4 de tim kiem nhan vien." +
                    "\n An 5 de kiem tra trang thai nhan vien." +
                    "\n An 6 de thay doi trang thai nhan vien. \n An 7 de xoa thong tin nhan vien" +
                    "\n An 8 xem thong tin tai khoan. \n An 9 de dang xuat");

            choice = validate.inputInteger();
            switch (choice) {
                case 1:
                    employeeView.addEmployee();
                    break;
                case 2:
                    employeeView.editEmployee();
                    break;
                case 3:
                    employeeView.choiceShow();
                    break;
                case 4:
                    employeeView.findByName();
                    break;
                case 5:
                    employeeView.checkStatus();
                    break;
                case 6:
                    employeeView.updateStatus();
                    break;
                case 7:
                    employeeView.deleteEmployee();
                    break;
                case 8:
                    managerAccountView.showManagerAccount(useName, password);
                    break;
            }
        }
    }
}