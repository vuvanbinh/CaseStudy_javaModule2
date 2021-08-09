package controller;

import model.Employee;
import model.FullTime;
import model.PartTime;
import stogera.FileEmployee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private String name;
    private List<Employee> employeeList = new ArrayList<>();

    public EmployeeManager() {
    }

    public EmployeeManager(String name, List<Employee> employeeList) {
        this.name = name;
        this.employeeList = employeeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void add(Employee employee) {
        employeeList.add(employee);
        FileEmployee.writeFile(employeeList,"employee.txt");
    }

    public void edit(String id,Employee employee){
        int index = getIndexOfId(id);
        employeeList.set(index,employee);
        FileEmployee.writeFile(employeeList,"employee.txt");
    }

    public void delete(String id) {
        int index = getIndexOfId(id);
        employeeList.remove(index);
        FileEmployee.writeFile(employeeList,"employee.txt");
    }

    public List<Employee> findByName(String name) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getName().equals(name)) {
                employees.add(employeeList.get(i));
            }
        }
        return employees;
    }

    public int calculationSalary(String id){
        int index = getIndexOfId(id);
        Employee employee = employeeList.get(index);
        if(employee instanceof FullTime){
           return employee.calculationSalary();
        }else return employee.calculationSalary();
    }

    public int getIndexOfUseName(String useName){
        int index=-1;
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if(employee.getUseName().equals(useName)){
                index = i;
                break;
            }
        }
        return index;
    }

    public int getIndexOfUseNamePassword(String useName, int password){
        int index = -1;
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if(employee.getUseName().equals(useName) && employee.getPassword()==password){
                index = i;
                break;
            }
        }
        return index;
    }

    public int getIndexOfId(String id) {
        int index = -1;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public List<Employee> getEmployeeStatus(String status) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if ( employeeList.get(i).getStatus().equals(status)) {
                employees.add(employeeList.get(i));
            }
        }
        return employees;
    }

    public void updateStatus(String id ){
        int index = getIndexOfId(id);
        if (employeeList.get(index).getStatus().equals("dang lam")){
            employeeList.get(index).setStatus("da nghi");
        }else employeeList.get(index).setStatus("dang lam");
        FileEmployee.writeFile(employeeList,"employee.txt");
    }

    public List<Employee> getClassifyEmployee(String classifyEmployee){
        List<Employee> classifyEmployees = new ArrayList<>();
        if(classifyEmployee.equals("fullTime")){
            for (int i = 0; i < employeeList.size(); i++) {
                if (employeeList.get(i)instanceof FullTime) classifyEmployees.add(employeeList.get(i));
            }
            return classifyEmployees;
        }else if(classifyEmployee.equals("partTime")){
            for (int i = 0; i < employeeList.size(); i++) {
                if (employeeList.get(i)instanceof PartTime) classifyEmployees.add(employeeList.get(i));
            }
            return classifyEmployees;
        }
        return null;
    }
}
