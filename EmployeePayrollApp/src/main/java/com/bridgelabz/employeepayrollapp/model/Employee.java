package com.bridgelabz.employeepayrollapp.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    private double salary;

    private LocalDate startDate;

    public Employee() {
    }

    public Employee(String name, double salary, LocalDate startDate) {
        this.name = name;
        this.salary = salary;
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
