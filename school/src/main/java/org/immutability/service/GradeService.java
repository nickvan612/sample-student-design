package org.immutability.service;

import org.immutability.aggregate.CourseEnrollment;
import org.immutability.data.Course;
import org.immutability.data.Grade;
import org.immutability.data.Student;
import org.immutability.table.CourseEnrollmentTable;

public class GradeService {
    public static void updateStudentGrade(Course course, Student student, Grade grade) {
        CourseEnrollment courseEnrollment = CourseEnrollmentTable.findCourseEnrollmentById(course.id().toString(), student.id().toString());
        CourseEnrollmentTable.removeCourseEnrollment(courseEnrollment);

        CourseEnrollment newCourseEnrollment = courseEnrollment.withGrade(grade);
        CourseEnrollmentTable.addCourseEnrollment(newCourseEnrollment);
    }

    public static double getStudentOverallGrade(Student student) {
        return CourseEnrollmentTable.getCourseEnrollmentSet().stream()
                .filter(c -> c.student().id().equals(student.id()))
                .map(CourseEnrollment::grade)
                .mapToDouble(Grade::gradePoint)
                .average()
                .orElse(Double.NaN);
    }
}
