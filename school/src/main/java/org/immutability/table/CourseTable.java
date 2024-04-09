package org.immutability.table;

import org.immutability.data.Course;

import java.util.HashSet;
import java.util.Set;

public final class CourseTable {
    private static final Set<Course> courseSet = new HashSet<>();

    private CourseTable() {
        // Singleton
    }

    public static Course findCourseByName(String courseName) {
        return courseSet.stream()
                .filter(c -> c.name().equalsIgnoreCase(courseName))
                .findFirst()
                .orElse(null);
    }

    public static void addCourse(Course course) {
        courseSet.add(course);
    }

    public static void removeCourse(Course course) {
        courseSet.remove(course);
    }

    public static Set<Course> getCourseSet() {
        return Set.copyOf(courseSet);
    }
}
