package com.example.CourseRegistration;

import java.util.*;

public class CourseRegistrationSystem {

    List<Course> courseList;
    Set<Student> studentSet;

    public CourseRegistrationSystem() {
        this.courseList = new ArrayList<>();
        this.studentSet = new HashSet<>();
    }

    public void createCourses(String courseId, String courseName) {
        Course course = new Course(courseId, courseName);
        courseList.add(course);
        System.out.println("Course "+courseId+" - "+courseName+" is created");
    }

    public void registerStudent(String studentId, String studentName, String courseId) {

        Student student = new Student(studentId, studentName);
        if (!studentSet.contains(student)) {
            studentSet.add(student);
        }

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
    
    public void findPairsWithSharedCourses() {
        //storing student pairs
        List<StudentPair> pairs = new ArrayList<>();
        
        //courses each student is enrolled in 
        Map<String, Set<Course>> studentCourses = new HashMap<>();

        //populate the student courses map
        for (Student student :studentSet) {
            studentCourses.put(student.getStudentId(), new HashSet<>());
        }

        for (Course course : courseList) {
            for (Student student : course.getEnrolledStudents()) {
                studentCourses.get(student.getStudentId()).add(course);
            }
        }

        //find pairs with shrared courses
        for (Map.Entry<String, Set<Course>> entry1: studentCourses.entrySet()) {
            String studentId1 = entry1.getKey();
            Set<Course> courses1 = entry1.getValue();

            for (Map.Entry<String, Set<Course>> entry2: studentCourses.entrySet()) {
                String studentId2 = entry2.getKey();
                Set<Course> courses2 = entry2.getValue();

                if(studentId1!=studentId2) {

                    Set<Course> sharedCourses = new HashSet<>(courses1);
                    sharedCourses.retainAll(courses2);

                    if(!sharedCourses.isEmpty()) {
                        Student student1 = findStudentById(studentId1);
                        Student student2 = findStudentById(studentId2);

                        StudentPair pair = new StudentPair(student1, student2);
                        pairs.add(pair);

                    }
                }
            }
        }

        for (StudentPair studentPair : pairs) {

            String name1 = studentPair.getStudent1().getStudentName();
            String name2 = studentPair.getStudent2().getStudentName();
            System.out.println(name1 +" & " +name2);
        }

    }

    private Student findStudentById(String studentId1) {
        for (Student student:studentSet) {
            if(student.getStudentId().equals(studentId1)) {
                return student;
            }
        }
        return null;
    }


}



























