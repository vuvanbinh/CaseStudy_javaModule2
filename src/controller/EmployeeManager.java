package controller;

import model.Employee;
import model.FullTime;
import model.PartTime;
import stogera.FileEmployee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private String name;
    private List<Employee> employeeList;

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

    public void editEmployee(String id,Employee employee){
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

    public List<Employee> EmployDoing() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if ( employeeList.get(i).getStatus().equals("dang lam")) {
                employees.add(employeeList.get(i));
            }
        }
        return employees;
    }

    public List<Employee> EmployNotDoing() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if ( employeeList.get(i).getStatus().equals("da nghi")) {
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

    public List<Employee> classifyFullTime(){
        List<Employee> fullTimes = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i)instanceof FullTime) fullTimes.add(employeeList.get(i));
        }
        return fullTimes;
    }

    public List<Employee> classifyPartTime(){
        List<Employee> partTimes = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i)instanceof PartTime) partTimes.add(employeeList.get(i));
        }
        return partTimes;
    }
}
