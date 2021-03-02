package kz.aitu.oop.practice.assignment5;
import kz.aitu.oop.practice.assignment5.controllers.EmployeeController;
import kz.aitu.oop.practice.assignment5.data.DBManager;
import kz.aitu.oop.practice.assignment5.data.interfaces.IDBManager;
import kz.aitu.oop.practice.assignment5.repositories.EmployeeReprository;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IEmployeeRepository;

public class Main {

    public static void main(String[] args) {
        IDBManager DBManager = new DBManager();
        IEmployeeRepository employeeRepository = new EmployeeReprository(DBManager);
        EmployeeController employeeController = new EmployeeController(employeeRepository);
        MyApplication myApplication = new MyApplication(employeeController);
        myApplication.start();

    }

}
