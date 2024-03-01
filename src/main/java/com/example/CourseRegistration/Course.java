package com.example.CourseRegistration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {

    private String courseId;
    private String courseName;
    private List<Student> enrolledStudents;

    private Map<Student, String> studentGrades;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        enrolledStudents = new ArrayList<>();
        studentGrades = new HashMap<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setEnrolledStudents(Student student) {
        enrolledStudents.add(student);
    }

    public void setStudentGrades(Student student, String grade) {
        studentGrades.put(student, grade);
        System.out.println(student.getStudentName() + " has been registered for " + courseName + " with grade " + grade);
    }
}
