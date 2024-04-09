package org.immutability.data;

public record Grade(double gradePoint) {
    public static Grade of(double gradePoint) {
        return new Grade(gradePoint);
    }
}
