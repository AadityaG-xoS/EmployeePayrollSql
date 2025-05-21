package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger();

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee(
                employeeDTO.getName(),
                employeeDTO.getSalary(),
                employeeDTO.getStartDate()
        );
        newEmployee.setId(idCounter.incrementAndGet());
        employeeList.add(newEmployee);
        return newEmployee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeList.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    @Override
    public Employee updateEmployee(int id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = getEmployeeById(id);
        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setSalary(employeeDTO.getSalary());
        existingEmployee.setStartDate(employeeDTO.getStartDate());
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(int id) {
        Employee employee = getEmployeeById(id);
        employeeList.remove(employee);
    }
}
