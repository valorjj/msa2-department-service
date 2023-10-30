package com.example.msa2departmentservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/*
* Eureka Server 에 해당 서비스를 등록한다.
*
* */

@SpringBootApplication
@EnableDiscoveryClient
public class Msa2DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Msa2DepartmentServiceApplication.class, args);
	}

}
