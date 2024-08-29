package com.peter.department_service.controller;

import com.peter.department_service.client.EmployeeClient;
import com.peter.department_service.model.Department;
import com.peter.department_service.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentRepository departmentRepository;

    private EmployeeClient employeeClient;


    @PostMapping("")
    public Department add(@RequestBody Department department) {
        LOGGER.info("Department add: {}", department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping()
    public List<Department> findAll() {
        LOGGER.info("Department find all");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id) {
        LOGGER.info("Department get by id, id : {}", id);
        return departmentRepository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        LOGGER.info("Department find all");
        List<Department> departments = departmentRepository.findAll();

        departments.forEach(department ->
                department.setEmployees(employeeClient.getEmployeesByDepartment(department.getId())));
        return departments;
    }

}
