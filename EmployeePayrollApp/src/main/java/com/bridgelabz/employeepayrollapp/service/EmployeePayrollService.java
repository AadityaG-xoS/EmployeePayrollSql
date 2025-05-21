package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeeRepo;

    @Override
    public List<EmployeePayrollData> getEmployeeData() {
        return employeeRepo.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeeById(int empId) {
        return employeeRepo.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + empId));
    }

    @Override
    public EmployeePayrollData createEmployee(EmployeePayrollDTO dto) {
        EmployeePayrollData newEmp = new EmployeePayrollData(0, dto.getName(), dto.getSalary());
        return employeeRepo.save(newEmp);
    }

    @Override
    public EmployeePayrollData updateEmployee(int empId, EmployeePayrollDTO dto) {
        EmployeePayrollData emp = this.getEmployeeById(empId);
        emp.setName(dto.getName());
        emp.setSalary(dto.getSalary());
        return employeeRepo.save(emp);
    }

    @Override
    public void deleteEmployee(int empId) {
        employeeRepo.deleteById(empId);
    }
}
