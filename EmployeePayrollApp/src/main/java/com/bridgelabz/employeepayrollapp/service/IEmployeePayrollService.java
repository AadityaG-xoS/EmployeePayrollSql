package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {

    List<EmployeePayrollData> getEmployeeData();

    EmployeePayrollData getEmployeeById(int empId);

    EmployeePayrollData createEmployee(EmployeePayrollDTO dto);

    EmployeePayrollData updateEmployee(int empId, EmployeePayrollDTO dto);

    void deleteEmployee(int empId);
}
