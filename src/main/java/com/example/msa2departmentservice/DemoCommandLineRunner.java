package com.example.msa2departmentservice;

import com.example.msa2departmentservice.controller.DepartmentController;
import com.example.msa2departmentservice.model.Department;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DemoCommandLineRunner implements CommandLineRunner {

    private final DepartmentController departmentController;
    @Override
    public void run(String... args) throws Exception {

        departmentController.add(Department.builder()
            .id(1L)
            .name("JAVA")
            .build()
        );
        departmentController.add(Department.builder()
            .id(2L)
            .name("React")
            .build());
        departmentController.add(Department.builder()
            .id(3L)
            .name("Node")
            .build());
    }

}
