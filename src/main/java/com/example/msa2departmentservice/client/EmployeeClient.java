package com.example.msa2departmentservice.client;

import com.example.msa2departmentservice.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {

    @GetExchange("/employee/department/{departmentId}")
    List<Employee> findByDepartment(@PathVariable("departmentId") Long id);


}
