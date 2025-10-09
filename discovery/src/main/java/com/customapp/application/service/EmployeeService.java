package com.customapp.application.service;

import java.util.List;

import com.customapp.application.model.Employee;
import com.customapp.application.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee){
        Employee employee1 = employeeRepository.save(employee);
        return employee1;
    }
}
