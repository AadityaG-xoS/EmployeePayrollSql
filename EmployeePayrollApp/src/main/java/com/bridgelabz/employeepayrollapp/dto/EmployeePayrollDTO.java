package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class EmployeePayrollDTO {

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Min(value = 1000, message = "Salary must be greater than 1000")
    private long salary;

    public EmployeePayrollDTO() {}

    public EmployeePayrollDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
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
