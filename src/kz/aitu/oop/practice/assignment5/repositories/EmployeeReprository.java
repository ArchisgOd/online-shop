package kz.aitu.oop.practice.assignment5.repositories;
import kz.aitu.oop.practice.assignment5.data.interfaces.IDBManager;
import kz.aitu.oop.practice.assignment5.entities.Employee;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeReprository implements IEmployeeRepository { // here i create class for methods
    private final IDBManager DBManager;

    public EmployeeReprository(IDBManager DBManager){ // simple constructor

        this.DBManager = DBManager;
    }


    @Override
    public ArrayList<Employee> searchEmployeeByName(String name) { // this my first method for find any employee by name
        Connection connection = null;
        try {
            connection = DBManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE name LIKE '%"+ name +"%' ");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Employee> employees = new ArrayList<>();
            while (resultSet.next()){
                Employee  employee = new Employee(resultSet.getInt("empid"),
                        resultSet.getInt("age"),
                        resultSet.getString("name" ),
                        resultSet.getString("address"),
                        resultSet.getString("status"),
                        resultSet.getString("specialization"),
                        resultSet.getDate("startdate").toLocalDate(),
                        resultSet.getInt("salary"));

                employees.add(employee);
            }
            return employees;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getEmployeeById(int id) { //  second method  to find employee by ID if you forget name of  employee
        Connection connection = null;
        try {
            connection = DBManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee  WHERE empid =?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = new Employee();
            if(resultSet.next()){
                employee.setId(resultSet.getInt("empid"));
                employee.setAge(resultSet.getInt("age"));
                employee.setName(resultSet.getString("name"));
                employee.setAddress(resultSet.getString("address"));
                employee.setStatus(resultSet.getString("status"));
                employee.setSpecialization(resultSet.getString("specialization"));
                employee.setStartdate(resultSet.getDate("startdate").toLocalDate());
                employee.setSalary(resultSet.getInt("salary"));
            }
            return employee;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addEmployee(Employee employee) { // this method to add a new worker
        Connection connection = null;
        try {
            connection = DBManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Employee(age, name, address, status, specialization, startdate, salary) VALUES(?, ?, ?, ?, ?, ?, ?) ");
            preparedStatement.setInt(1, employee.getAge());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getStatus());
            preparedStatement.setString(5, employee.getSpecialization());
            preparedStatement.setDate(6, Date.valueOf(employee.getStartdate()));
            preparedStatement.setInt(7, employee.getSalary());
            preparedStatement.execute();

            return  true;

        }
        catch (Exception e){
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public boolean removeEmployeeById(int id) { // this function to delete workers which was fired or left the job
        Connection connection = null;
        try {
            connection = DBManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM  employee  WHERE  empid=?");
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            return true;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<Employee> showAllEmployee() { //  method to see all workers in this Company
        Connection connection = null;
        try {
            connection = DBManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee ");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Employee> employees = new ArrayList<>();
            while (resultSet.next()){
                Employee  employee = new Employee(
                        resultSet.getInt("empid"),
                        resultSet.getInt("age"),
                        resultSet.getString("name" ),
                        resultSet.getString("address"),
                        resultSet.getString("status"),
                        resultSet.getString("specialization"),
                        resultSet.getDate("startdate").toLocalDate(),
                        resultSet.getInt("salary"));
                employees.add(employee);
            }
            return employees;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public int totalsalary() { //  to calculate the total salary of workers
        Connection connection = null;
        try {
            connection = DBManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT SUM(salary) FROM employee ");
            preparedStatement.executeQuery();
            ResultSet resultSet =  preparedStatement.executeQuery();
            if(resultSet.next()){}
            return  resultSet.getInt("sum");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
