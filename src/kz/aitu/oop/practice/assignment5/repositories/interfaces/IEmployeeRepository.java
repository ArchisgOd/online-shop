package kz.aitu.oop.practice.assignment5.repositories.interfaces;
import kz.aitu.oop.practice.assignment5.entities.Employee;
import java.util.ArrayList;

public interface IEmployeeRepository { // this is interface of EmployeeRepository

        public ArrayList<Employee> searchEmployeeByName(String name);
        public Employee getEmployeeById(int id);
        public boolean addEmployee(Employee employee);
        public boolean removeEmployeeById(int id);
        public ArrayList<Employee> showAllEmployee();
        public int totalsalary();

}
