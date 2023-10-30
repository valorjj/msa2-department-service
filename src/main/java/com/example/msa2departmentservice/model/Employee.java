package com.example.msa2departmentservice.model;

public record Employee(
    Long id,
    Long departmentId,
    String name,
    Integer age,
    String position
) {
}
