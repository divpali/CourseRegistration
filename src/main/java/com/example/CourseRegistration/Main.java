package com.example.CourseRegistration;

public class Main {

    public static void main(String[] args) {
        CourseRegistrationSystem registrationSystem = new CourseRegistrationSystem();
        registrationSystem.createCourses("CS101", "Intro to CS");
        registrationSystem.createCourses("Math127", "Algebra");

        registrationSystem.registerStudent("S101","name1", "CS101");
        registrationSystem.registerStudent("S102","name2", "CS101");
        registrationSystem.registerStudent("S103","name3", "Math127");
    }
}
