package org.example.entites.dto;


import org.example.entites.jpql.Student;

public record CountedEnrollmentForStudent(
        String s,
        Long count
) {
}