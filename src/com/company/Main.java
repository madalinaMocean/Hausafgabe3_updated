package com.company;

import com.company.controllers.RegistrationSystem;
import com.company.models.Course;
import com.company.models.Student;
import com.company.models.Teacher;

public class Main {

    public static void main(String[] args) {
        RegistrationSystem registrationSystem = new RegistrationSystem();

        Teacher teacher1 = new Teacher("Dan", "Doe");
        Teacher teacher2 = new Teacher("Mary", "Jane");

        Course course1 = new Course("APM", teacher1, 1, 6);
        registrationSystem.courseList.create(course1); // add course to registration
        Course course2 = new Course("DSA", teacher2, 3, 6);
        registrationSystem.courseList.create(course2);

        Student student1 = new Student("James", "Blonde", 1);
        Student student2 = new Student("Jane", "Flower", 1);

        registrationSystem.register(course1,student1); // can register
        registrationSystem.register(course2,student1); // can register
        registrationSystem.register(course1,student2); // cannot register - course 1 is full
        registrationSystem.register(course2,student2); // re-tries to register to another course

        System.out.print("Available Courses: ");
        registrationSystem.retrieveCoursesWithFreePlaces().forEach( course -> System.out.print(course.getCourseName()+", "));
        System.out.println();

        System.out.print("Students enrolled in APM Course: ");
        registrationSystem.retrieveStudentsEnrolledForACourse(course1)
                .forEach( student -> System.out.print(student.getFirstName()+" "+student.getLastName()+", "));
        System.out.println();

        System.out.print("Students enrolled in DSA Course: ");
        registrationSystem.retrieveStudentsEnrolledForACourse(course2)
                .forEach( student -> System.out.print(student.getFirstName()+" "+student.getLastName()+", "));
    }
}
