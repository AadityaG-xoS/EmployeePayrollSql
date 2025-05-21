package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeeService;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getAllEmployees() {
        List<EmployeePayrollData> list = employeeService.getEmployeeData();
        ResponseDTO resp = new ResponseDTO("Get all employees success", list);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getEmployee(@PathVariable int id) {
        EmployeePayrollData data = employeeService.getEmployeeById(id);
        ResponseDTO resp = new ResponseDTO("Get employee success", data);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployee(@Valid @RequestBody EmployeePayrollDTO dto) {
        EmployeePayrollData data = employeeService.createEmployee(dto);
        ResponseDTO resp = new ResponseDTO("Created successfully", data);
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeePayrollDTO dto) {
        EmployeePayrollData data = employeeService.updateEmployee(id, dto);
        ResponseDTO resp = new ResponseDTO("Updated successfully", data);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        ResponseDTO resp = new ResponseDTO("Deleted successfully", null);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
