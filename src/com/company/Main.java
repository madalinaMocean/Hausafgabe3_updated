package com.company;

import com.company.controllers.RegistrationSystem;
import com.company.models.Course;
import com.company.models.Student;
import com.company.models.Teacher;

public class Main {

    public static void main(String[] args) {
        RegistrationSystem registrationSystem = new RegistrationSystem();

        Teacher t1 = new Teacher("Dan", "Doe");
        Teacher t2 = new Teacher("Mary", "Jane");

        Course c1 = new Course("APM", t1, 1, 6);
        registrationSystem.courseList.create(c1); // add course to registration
        Course c2 = new Course("DSA", t2, 3, 6);
        registrationSystem.courseList.create(c2);

        Student s1 = new Student("James", "Blonde", 1);
        Student s2 = new Student("Jane", "Flower", 1);

        registrationSystem.register(c1,s1); // can register
        registrationSystem.register(c2,s1); // can register
        registrationSystem.register(c1,s2); // cannot register - course 1 is full
        registrationSystem.register(c2,s2); // re-tries to register to another course

        System.out.print("Available Courses: ");
        registrationSystem.retrieveCoursesWithFreePlaces().forEach( course -> System.out.print(course.getCourseName()+", "));
        System.out.println();

        System.out.print("Students enrolled in APM Course: ");
        registrationSystem.retrieveStudentsEnrolledForACourse(c1)
                .forEach( student -> System.out.print(student.getFirstName()+" "+student.getLastName()+", "));
        System.out.println();

        System.out.print("Students enrolled in DSA Course: ");
        registrationSystem.retrieveStudentsEnrolledForACourse(c2)
                .forEach( student -> System.out.print(student.getFirstName()+" "+student.getLastName()+", "));
    }
}
