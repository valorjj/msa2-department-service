package com.example.msa2departmentservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


/*
* 간단한 시연을 위한 엔티티 역할을 하는 클래스
*
* */
@Getter
@Setter
@NoArgsConstructor
public class Department {

    private Long id;

    private String name;

    private List<Employee> employees = new ArrayList<>();
    @Builder
    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", employees=" + employees +
            '}';
    }
}
