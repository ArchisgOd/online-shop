package kz.aitu.oop.practice.assignment5.entities;

import java.time.LocalDate;

public class Employee {
    private int id;
    private int age;
    private String name;
    private String address;
    private String status;
    private String specialization;
    private LocalDate startdate;
    private int salary;

    public Employee() {
    }

    public Employee( int age, String name, String address, String status, String specialization, LocalDate startdate, int salary) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.status = status;
        this.specialization = specialization;
        this.startdate = startdate;
        this.salary = salary;
    }

    public Employee(int id, int age, String name, String address, String status, String specialization, LocalDate startdate, int salary) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.address = address;
        this.status = status;
        this.specialization = specialization;
        this.startdate = startdate;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", specialization='" + specialization + '\'' +
                ", startdate=" + startdate +
                ", salary=" + salary +
                '}';
    }
}
