package kz.aitu.oop.practice.assignment5.controllers;
import java.time.LocalDate;
import java.util.ArrayList;
import kz.aitu.oop.practice.assignment5.data.interfaces.IDBManager;
import kz.aitu.oop.practice.assignment5.entities.Employee;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IEmployeeRepository;

public class EmployeeController{ // this class for  connection between MyApplication and EmployeeRepository
    private final IEmployeeRepository employeeRepository;

    public EmployeeController(IEmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    public String searchEmployeeByName(String name){
        String result = employeeRepository.searchEmployeeByName(name).toString();
        return  result;
    }
    public String getEmployeeById(int id){
        String result = employeeRepository.getEmployeeById(id).toString();
        return  result;
    }
    public  String addEmployee(int age, String name, String address, String status, String specialization, LocalDate startdate, int salary){

        boolean added = employeeRepository.addEmployee(new Employee(age, name, address, status, specialization, startdate, salary));
        if(added){
            return "This employee was added in DataBases!";
        }
        return "This employee was not added in DataBases";
    }
    public  String removeEmployeeById(int id){
        boolean removed = employeeRepository.removeEmployeeById(id);
        if(removed){
            return "Employee was fired";
        }
        return "Employee was not fired";
    }
    public  String showAllEmployee(){
        String result = employeeRepository.showAllEmployee().toString();
        return result;
    }
    public  String totalsalary(){
        String result = String.valueOf(employeeRepository.totalsalary());
        return  result;
    }

}
