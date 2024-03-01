package com.example.CourseRegistration;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CourseRegistrationSystem registrationSystem = new CourseRegistrationSystem();
        registrationSystem.createCourses("CSE101", "Intro to CS");
        registrationSystem.createCourses("MAT127", "Algebra");

        registrationSystem.registerStudent("st001","name1", "CSE101", "A");
        registrationSystem.registerStudent("st002","name2", "CSE101", "B");
        registrationSystem.registerStudent("st003","name3", "MAT127", "A");

        registrationSystem.findPairsWithSharedCourses();

        System.out.println(registrationSystem.getStudentGPA("st001"));

        List<StudentRecord> nominees = registrationSystem.getBestStudentNominees();

        System.out.println("Best student nominees");
        for (StudentRecord nominee: nominees) {
            System.out.println(nominee.getStudent().getStudentId());
        }
    }
}
