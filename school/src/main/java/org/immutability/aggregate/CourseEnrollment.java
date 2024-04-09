package org.immutability.aggregate;

import org.immutability.data.Course;
import org.immutability.data.Grade;
import org.immutability.data.Student;

public record CourseEnrollment(Course course, Student student, Grade grade) {
    // TODO: Aggregate? Or Composite?
    public boolean matchesStudentId(String studentId) {
        String currentStudentId = student().id().toString();
        return currentStudentId.equals(studentId);
    }

    public boolean matchesStudentId(String courseId, String studentId) {
        String currentCourseId = course().id().toString();
        String currentStudentId = student().id().toString();
        return currentCourseId.equals(courseId) && currentStudentId.equals(studentId);
    }

    public CourseEnrollment withGrade(Grade grade) {
        return new CourseEnrollment(course(), student(), grade);
    }
}
