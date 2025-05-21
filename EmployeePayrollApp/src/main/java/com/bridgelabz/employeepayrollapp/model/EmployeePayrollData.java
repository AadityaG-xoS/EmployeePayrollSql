package com.bridgelabz.employeepayrollapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_payroll")
public class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private long salary;

    public EmployeePayrollData() {
    }

    public EmployeePayrollData(int id, String name, long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
