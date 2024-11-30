package org.example.entites.dto;

import org.example.entites.jpql.Enrollment;
import org.example.entites.jpql.Student;

public record EnrolledStudent(
        Student student,
        Enrollment enrollment
) {
}
