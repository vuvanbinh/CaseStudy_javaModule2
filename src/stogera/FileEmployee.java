package stogera;

import model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileEmployee {

    public static void writeFile(List<Employee> employeeList,String fileName){
        File file = new File(fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employeeList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> readFile(String fileName){
        List<Employee> employees = new ArrayList<>();
        File file = new File(fileName);
        if(file.length()>0){
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                employees = (List<Employee>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }
}
