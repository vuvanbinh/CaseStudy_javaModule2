package controller;

import model.Employee;
import stogera.FileEmployee;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    List<Employee> accountList = new ArrayList<>();

    public AccountManager(List<Employee> accountList) {
        this.accountList = accountList;
    }

    public void add(Employee employee){
        accountList.add(employee);
        FileEmployee.writeFile(accountList,"account.txt");
    }

    public int getIndexOfUseName(String useName){
        int index = -1;
        for (int i = 0; i < accountList.size(); i++) {
            if(accountList.get(i).getUseName().equals(useName)){
                index=i;
                break;
            }
        }
        return index;
    }
     public int getIndexOfId(String id){
        int index = -1;
        for (int i = 0; i < accountList.size(); i++) {
            if(accountList.get(i).getId().equals(id)){
                index=i;
                break;
            }
        }
        return index;
    }

    public void delete(String useName){
        accountList.remove(getIndexOfUseName(useName));
        FileEmployee.writeFile(accountList,"account.txt");
    }

    public List<Employee> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Employee> accountList) {
        this.accountList = accountList;
    }
}
