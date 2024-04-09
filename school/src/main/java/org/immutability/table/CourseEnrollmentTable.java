package org.immutability.table;

import org.immutability.aggregate.CourseEnrollment;
import org.immutability.data.Course;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class CourseEnrollmentTable {
    private static final Set<CourseEnrollment> courseEnrollmentSet = new HashSet<>();

    private CourseEnrollmentTable() {
        // Singleton
    }

    public static CourseEnrollment findCourseEnrollmentById(String courseId, String studentId) {
        return courseEnrollmentSet.stream()
                .filter(e -> e.matchesStudentId(courseId, studentId))
                .findFirst()
                .orElse(null);
    }

    public static void addCourseEnrollment(CourseEnrollment courseEnrollment) {
        courseEnrollmentSet.add(courseEnrollment);
    }

    public static void removeCourseEnrollment(CourseEnrollment courseEnrollment) {
        courseEnrollmentSet.remove(courseEnrollment);
    }

    public static Set<CourseEnrollment> getCourseEnrollmentSet() {
        return Set.copyOf(courseEnrollmentSet);
    }

    public static List<Course> findCourseEnrollmentsByStudentId(String studentId) {
        return courseEnrollmentSet.stream()
                .filter(e -> e.matchesStudentId(studentId))
                .map(CourseEnrollment::course)
                .toList();
    }
}
