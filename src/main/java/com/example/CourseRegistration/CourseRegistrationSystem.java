package com.example.CourseRegistration;

import java.util.*;

public class CourseRegistrationSystem {

    private List<Course> courseList;
    private Set<Student> studentSet;

    private List<StudentRecord> studentRecords;

    public CourseRegistrationSystem() {
        this.courseList = new ArrayList<>();
        this.studentSet = new HashSet<>();
        this.studentRecords = new ArrayList<>();
    }

    public void createCourses(String courseId, String courseName) {
        Course course = new Course(courseId, courseName);
        courseList.add(course);
        System.out.println("Course "+courseId+" - "+courseName+" is created");
    }

    public void registerStudent(String studentId, String studentName, String courseId, String grade) {

        Student student = findStudentById(studentId);

        if(student == null) {
            student = new Student(studentId, studentName);
            StudentRecord studentRecord = new StudentRecord(student);    //create student & its record, which also creates a map of course the student has taken with its grade that he has gotten
            studentRecords.add(studentRecord);
        }

        if (!studentSet.contains(student)) {
            studentSet.add(student);
        }

        Course course = getCourse(courseId);

        if (course!=null) {
            course.setEnrolledStudents(student);
            StudentRecord studentRecord = findStudentRecord(student);
            studentRecord.addGrade(courseId, grade);
            System.out.println(student.getStudentName() + " has been registered for " + course.getCourseName());
        } else {
            System.out.println("Course with code " + courseId + " not found.");
        }
    }

    public double getStudentGPA(String studentId) {
        StudentRecord studentRecord = findStudentRecordById(studentId);
        return studentRecord != null ? studentRecord.computeGPA() : 0.0;
    }

    private StudentRecord findStudentRecordById(String studentId) {
        for (StudentRecord studentRecord : studentRecords) {
            if(studentRecord.getStudent().getStudentId().equals(studentId)) {
                return studentRecord;
            }
        }
        return null;
    }

    private Course getCourse(String courseId) {
        for (Course course : courseList) {
            if(course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    private StudentRecord findStudentRecord(Student student) {
        for (StudentRecord studentRecord : studentRecords) {
            if (studentRecord.getStudent().equals(student)) {
                return studentRecord;
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



























