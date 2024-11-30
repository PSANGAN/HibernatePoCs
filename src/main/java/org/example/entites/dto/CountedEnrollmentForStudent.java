package org.example.entites.dto;


import org.example.entites.jpql.Student;

public record CountedEnrollmentForStudent(
        Student s,
        Long count
) {
}