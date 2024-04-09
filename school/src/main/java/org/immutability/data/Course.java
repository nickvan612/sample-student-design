package org.immutability.data;

import org.immutability.table.CourseTable;

import java.util.Objects;
import java.util.UUID;

public record Course(UUID id, String name) {
    /**
     * Returns a Course with the new name, with the same ID
     * @return a Course with the new name, with the same ID
     */
    public Course updateName(String courseName) {
        return new Course(this.id, courseName);
    }

    public static Course of(String courseName) {
        Course existingCourse = CourseTable.findCourseByName(courseName);
        if (existingCourse != null) {
            return existingCourse;
        }

        Course newCourse = new Course(UUID.randomUUID(), courseName);
        CourseTable.addCourse(newCourse);
        return newCourse;
    }

    @Override
    public String toString() {
        return name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id.equals(course.id) && name.equals(course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
