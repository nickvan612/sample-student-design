package org.immutability.service;

import org.immutability.data.Course;
import org.immutability.data.Grade;
import org.immutability.data.Student;
import org.immutability.aggregate.CourseEnrollment;
import org.immutability.table.CourseEnrollmentTable;
import org.immutability.table.StudentTable;

import java.time.LocalDate;
import java.util.UUID;

public final class EnrollmentService {
    public static Student enrollStudentInSchool(String studentName, LocalDate enrollDate) {
        Student newStudent = new Student(UUID.randomUUID(), studentName, enrollDate);
        StudentTable.addStudent(newStudent);
        return newStudent;
    }

    public static void enrollStudentInCourse(Course course, Student student) {
        CourseEnrollment newCourseEnrollment = new CourseEnrollment(course, student, Grade.of(Double.NaN));
        CourseEnrollmentTable.addCourseEnrollment(newCourseEnrollment);
    }
}
