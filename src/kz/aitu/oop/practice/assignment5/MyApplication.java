package kz.aitu.oop.practice.assignment5;
import  kz.aitu.oop.practice.assignment5.controllers.EmployeeController;
import kz.aitu.oop.practice.assignment5.entities.Employee;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.SplittableRandom;
public class MyApplication {
    final EmployeeController employeeController;
    private final Scanner scanner;

    public MyApplication(EmployeeController employeeController){ // this application  for make convenient  interface for users and make simple
        this.employeeController = employeeController;
        scanner = new Scanner(System.in);

    }
    public void  start(){
        while (true){
            System.out.println("Choose one option: \n 1) Search for employee by name\n 2) Find employee by ID\n 3)  Hire a new employee\n 4) Dismiss an employee\n 5) To show all Employees\n 6) To show Company salary\n 0)  Exit\n ");
            int   choice =  scanner.nextInt();
            if(choice== 1){
                searchEmployeeByNameMenu();
            }
            else if(choice == 2){
                getEmployeeByIdMenu();
            }
            else if(choice ==3){
                addEmployeeMenu();
            }
            else  if(choice ==4){
                FireEmployeeMenu();
            }
            else  if(choice ==5){
                showAllemployee();
            }
            else  if(choice ==6){
                totalsalary();
            }
            else {
                break;
            }
            System.out.println("------------------------");
        }
    }
    public void searchEmployeeByNameMenu(){
        System.out.println("Write name of Employee!");

        String name =  scanner.next();
        String result = employeeController.searchEmployeeByName(name);
        System.out.println(result);
    }
    public void getEmployeeByIdMenu(){
        System.out.println("Write the ID of Employee!");
        int id = scanner.nextInt();
        String result = employeeController.getEmployeeById(id);
        System.out.println(result);
    }
    public void addEmployeeMenu(){
        System.out.println("Write age");
        int age =  scanner.nextInt();

        System.out.println("Write the name of new Employee!");
        String name =  scanner.next();

        System.out.println("Write  address of new Employee");
        String address =  scanner.next();

        System.out.println("Write status of new Employee");
        String status =  scanner.next();

        System.out.println("Write  specialization of new Employee");
        String specialization =  scanner.next();

        System.out.println("Write date of working of new Employee");
        String date = scanner.next();
        LocalDate startdate = LocalDate.parse(date);

        System.out.println("Write  salary of new Employee");
        int salary =  scanner.nextInt();

        String result =  employeeController.addEmployee(age, name, address, status, specialization, startdate, salary);
        System.out.println(result);
    }
    public void FireEmployeeMenu(){
        System.out.println("Write the ID of the Medicine Which you want delete!");
        int id = scanner.nextInt();
        String result = employeeController.removeEmployeeById(id);
        System.out.println(result);
    }
    public  void showAllemployee(){
        String result = employeeController.showAllEmployee();
        System.out.println(result);
    }
    public  void totalsalary(){
        String result = employeeController.totalsalary();
        System.out.println(result);
    }
}
