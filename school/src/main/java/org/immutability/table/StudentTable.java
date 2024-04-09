package org.immutability.table;

import org.immutability.data.Student;


import java.util.HashSet;
import java.util.Set;

public final class StudentTable {
    private static final Set<Student> studentSet = new HashSet<>();

    private StudentTable() {
        // Singleton
    }

    public static void addStudent(Student student) {
        studentSet.add(student);
    }

    public static void removeStudent(Student student) {
        studentSet.remove(student);
    }

    public static Set<Student> getStudentSet() {
        return Set.copyOf(studentSet);
    }
}
