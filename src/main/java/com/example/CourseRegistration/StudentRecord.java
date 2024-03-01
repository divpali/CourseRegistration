package com.example.CourseRegistration;

import java.util.HashMap;
import java.util.Map;

//keep track of a student's performance in different courses
public class StudentRecord {

    private Student student;
    private Map<String, String> courseGrade;

    public StudentRecord(Student student) {
        this.student = student;
        courseGrade = new HashMap<>();
    }

    public Student getStudent() {
        return student;
    }

    public void addGrade(String courseId, String grade) {
        courseGrade.put(courseId, grade);
    }

    public int mapGradesToGPA(String grade) {
        switch (grade) {
            case "A" : return 4;
            case "B" : return 3;
            case "C" : return 2;
            case "D" : return 1;
            default: return 0;
        }
    }

    public double computeGPA() {

        if (courseGrade.isEmpty()) {
            return 0.0;
        }

        int totalPoints = 0;
        int totalCourses = 0;

        for (String grade : courseGrade.values()) {
            int points = mapGradesToGPA(grade);
            totalPoints += points;
            totalCourses++;
        }

        return (double) (totalPoints/totalCourses);
    }
}
