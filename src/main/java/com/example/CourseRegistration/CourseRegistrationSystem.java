package com.example.CourseRegistration;

import java.util.ArrayList;
import java.util.List;

public class CourseRegistrationSystem {

    List<Course> courseList;
    List<Student> studentList;

    public CourseRegistrationSystem() {
        this.courseList = new ArrayList<>();
        this.studentList = new ArrayList<>();
    }

    public void createCourses(String courseId, String courseName) {
        Course course = new Course(courseId, courseName);
        courseList.add(course);
        System.out.println("Course "+courseId+" - "+courseName+" is created");
    }

    public void registerStudent(String studentId, String studentName, String courseId) {
        Student student = new Student(studentId, studentName);
        Course course = getCourse(courseId);

        if (course!=null) {
            course.setEnrolledStudents(student);
            System.out.println(student.getStudentName() + " has been registered for " + course.getCourseName());
        } else {
            System.out.println("Course with code " + courseId + " not found.");
        }
    }

    private Course getCourse(String courseId) {
        for (Course course : courseList) {
            if(course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }


}
