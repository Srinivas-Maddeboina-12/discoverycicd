package com.customapp.application.controller;

import com.customapp.application.dto.EmployeeDto;
import com.customapp.application.model.Employee;
import com.customapp.application.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Operation(summary = "Get all employees", description = "Retrieve a list of all employees")
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @Operation(summary = "Add a new employee", description = "Add a new employee to the system")
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody EmployeeDto employee){
        return employeeService.addEmployee(employee);
    }
}

