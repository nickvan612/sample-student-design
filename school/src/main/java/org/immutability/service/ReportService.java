package org.immutability.service;

import org.immutability.data.Course;
import org.immutability.data.Student;
import org.immutability.table.CourseEnrollmentTable;
import org.immutability.table.CourseTable;
import org.immutability.table.StudentTable;

import java.util.Comparator;
import java.util.Set;

public final class ReportService {
    public static void printAllStudents() {
        System.out.println("----------- Printing All Students ------------");
        StudentTable.getStudentSet().stream()
                .sorted(((o1, o2) -> o1.name().compareToIgnoreCase(o2.name())))
                .forEachOrdered(s -> System.out.println(s.getText()));
        System.out.println("-----------------------");
    }

    public static void printAllSmartStudents() {
        System.out.println("----------- Printing Smart Students ------------");
        StudentTable.getStudentSet().stream()
                .filter(Student::isSmart)
                .sorted(((o1, o2) -> o1.name().compareToIgnoreCase(o2.name())))
                .forEachOrdered(s -> System.out.println(s.getText()));
        System.out.println("------------------------");
    }

    public static void printThirdYearStudents() {
        System.out.println("----------- Printing Third Years ------------");
        StudentTable.getStudentSet().stream()
                .filter(s -> s.classYear() == 3)
                .sorted(((o1, o2) -> o1.name().compareToIgnoreCase(o2.name())))
                .forEachOrdered(s -> System.out.println(s.getText()));
        System.out.println("-----------------------");
    }

    public static void printInGradeOrder() {
        System.out.println("----------- Printing in Grade Order ------------");
        StudentTable.getStudentSet().stream()
                .sorted((Comparator.comparingDouble(Student::overallGrade)))
                .forEachOrdered(s -> System.out.println(s.getText()));
        System.out.println("-------------------------------");
    }

    public static void printAllGrades() {
        System.out.println("----------- Printing All Grades ------------");
        CourseEnrollmentTable.getCourseEnrollmentSet().stream()
                .sorted((o1, o2) -> o1.student().name().compareToIgnoreCase(o2.student().name()))
                .forEach(e -> System.out.printf("Student : %s | Course: %s | Grade: %s\n", e.student().name(), e.course().name(), e.grade().gradePoint()));
        System.out.println("-------------------------------");
    }

    public static void printAllCourses() {
        System.out.println("----------- Printing All Courses ------------");
        Set<Course> x = CourseTable.getCourseSet();
        CourseTable.getCourseSet().stream()
                .sorted((o1, o2) -> o1.name().compareToIgnoreCase(o2.name()))
                .forEach(c -> System.out.println(c.name()));
        System.out.println("-------------------------------");
    }
}
