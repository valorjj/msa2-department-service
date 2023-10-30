package com.example.msa2departmentservice.controller;

import com.example.msa2departmentservice.client.EmployeeClient;
import com.example.msa2departmentservice.model.Department;
import com.example.msa2departmentservice.repository.DepartmentRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    /*
     * Instead of using Sl4j
     * Log4j2 is known to be faster about 20% than Sl4j
     * */
    private static final Logger LOGGER
        = LoggerFactory.getLogger(DepartmentController.class);

    private final DepartmentRepository departmentRepository;
    private final EmployeeClient employeeClient;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Department add(@RequestBody Department department) {
        LOGGER.info("Department add: {}", department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Department> findAll() {
        LOGGER.info("Department find");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Department findById(@PathVariable("id") Long departmentId) {
        LOGGER.info("Department find: id ={}", departmentId);
        return departmentRepository.findById(departmentId);
    }

    @GetMapping("/with-employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Department> findAllWithEmployees() {
        LOGGER.info("Department find with employees");
        List<Department> departments
            = departmentRepository.findAll();

        departments.forEach(department
            -> department.setEmployees(employeeClient.findByDepartment(department.getId()))
        );

        return departments;
    }


}
