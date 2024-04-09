package org.immutability;

import org.immutability.data.Course;
import org.immutability.data.Grade;
import org.immutability.data.Student;
import org.immutability.service.EnrollmentService;
import org.immutability.service.GradeService;
import org.immutability.service.ReportService;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        initSchoolDataset();

        ReportService.printAllStudents();
        ReportService.printAllSmartStudents();
        ReportService.printThirdYearStudents();
        ReportService.printInGradeOrder();
        ReportService.printAllGrades();
        ReportService.printAllCourses();
    }

    private static void initSchoolDataset() {
        for (int i = 0; i < 10; i++) {
            String studentName = studentNamePool().get(i);
            LocalDate enrollDate = LocalDate.now().minusYears(i);
            Student student = EnrollmentService.enrollStudentInSchool(studentName, enrollDate);

            List<Course> courses = IntStream.range(1, i)
                    .mapToObj(num -> courseNamePool().get(num))
                    .map(Course::of)
                    .toList();
            courses.forEach(c -> EnrollmentService.enrollStudentInCourse(c, student));

            courses.forEach(c -> GradeService.updateStudentGrade(c, student, getRandomGrade()));
            Function<Student, String> functionGetName = s -> s.name();
        }
    }

    private static Grade getRandomGrade() {
        Random random = new Random();
        return Grade.of(random.nextDouble(65, 100));
    }

    private static List<String> studentNamePool() {
        String randomNames = """
                Carolyn Salgado
                Trace Hardin
                Vada Prince
                Aron Curtis
                Alexis Ponce
                Langston Burch
                Freyja Chambers
                Orion Stokes
                Miranda Carter
                Maverick Galindo
                Corinne Molina
                Prince Lynn
                Samira Zuniga
                Sincere Moore
                Emily Pace
                Dior Person
                Dylan Christensen
                Gregory Proctor""";
        return List.of(randomNames.split("\n"));
    }

    private static List<String> courseNamePool() {
        return List.of("Math", "Physics", "Chemistry", "Art", "Engineering", "Computer Science", "History",
                "Philosophy", "Physical Education", "English", "Communications");
    }
}
