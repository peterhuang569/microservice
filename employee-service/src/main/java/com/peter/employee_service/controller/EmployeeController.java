package com.peter.employee_service.controller;

import com.peter.employee_service.model.Employee;
import com.peter.employee_service.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        LOGGER.info("Adding a new employee: {}", employee);
        return employeeRepository.add(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        LOGGER.info("Fetching all employees");
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        LOGGER.info("Fetching employee with ID: {}", id);
        return employeeRepository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> getEmployeesByDepartment(@PathVariable Long departmentId) {
        LOGGER.info("Fetching employees from department ID: {}", departmentId);
        return employeeRepository.findByDepartment(departmentId);
    }
}
