package org.immutability.data;

import org.immutability.service.GradeService;
import org.immutability.table.CourseEnrollmentTable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record Student(UUID id, String name, LocalDate enrollDate) {
    public boolean isSmart() {
        return true;
    }

    public int classYear() {
        return LocalDate.now().getYear() - enrollDate().getYear();
    }

    public double overallGrade() {
        return GradeService.getStudentOverallGrade(this);
    }

    public List<Course> coursesTaking() {
        return CourseEnrollmentTable.findCourseEnrollmentsByStudentId(id().toString());
    }

    public String getText() {
        return String.format("Name: %s\nClass: %d\nGrade: %f\nCourses: %s", name(), classYear(), overallGrade(), coursesTaking().toString());
    }
}
