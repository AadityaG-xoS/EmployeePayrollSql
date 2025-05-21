package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @GetMapping("/")
    public ResponseEntity<String> getAllEmployees() {
        return ResponseEntity.ok("GET All Employees Success");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getEmployee(@PathVariable("id") int id) {
        return ResponseEntity.ok("GET Employee with ID: " + id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Map<String, Object> payload) {
        return ResponseEntity.ok("POST Created Employee: " + payload.toString());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable("id") int id,
                                                 @RequestBody Map<String, Object> payload) {
        return ResponseEntity.ok("PUT Updated Employee ID " + id + " with: " + payload.toString());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
        return ResponseEntity.ok("DELETE Removed Employee ID: " + id);
    }
}
