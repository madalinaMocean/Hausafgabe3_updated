package com.company.controllers;

import com.company.models.Course;
import com.company.models.Student;
import com.company.models.Teacher;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationSystemTest {
    RegistrationSystem registrationSystem = new RegistrationSystem();

    Teacher t1 = new Teacher("Dan", "Doe");
    Teacher t2 = new Teacher("Mary", "Jane");

    Course c1 = new Course("APM", t1, 1, 6);
    Course c2 = new Course("DSA", t2, 3, 6);

    Student s1 = new Student("James", "Blonde", 1);
    Student s2 = new Student("Jane", "Flower", 1);

    @Test
    void register() {
        assert(registrationSystem.register(c1,s1));
        assert(!registrationSystem.register(c1,s2));
        assert(!registrationSystem.register(c1,s1));
    }

    @Test
    void retrieveCoursesWithFreePlaces() {
        assert(registrationSystem.retrieveCoursesWithFreePlaces().isEmpty());
        registrationSystem.courseList.create(c1);
        registrationSystem.register(c1,s1);
        assert(registrationSystem.retrieveCoursesWithFreePlaces().isEmpty());
        registrationSystem.courseList.create(c2);
        assert(registrationSystem.retrieveCoursesWithFreePlaces().size()==1);
    }

    @Test
    void retrieveStudentsEnrolledForACourse() {
        registrationSystem.courseList.create(c1);
        registrationSystem.register(c1,s1);
        assert(registrationSystem.retrieveStudentsEnrolledForACourse(c1).size()==1);
    }

    @Test
    void getAllCourses() {
        registrationSystem.courseList.create(c1);
        registrationSystem.courseList.create(c2);
        assert(registrationSystem.getAllCourses().size()==2);
    }

    @Test
    void deleteCourseByTeacher() {
        registrationSystem.courseList.create(c1); // add course to registration
        registrationSystem.register(c1,s1);
        List<Course> t1c = new ArrayList<Course>();
        t1c.add(c1);
        t1.setCourses(t1c);
        assert(!t1.getCourses().isEmpty());
        registrationSystem.deleteCourseByTeacher(t1, c1);
        assert(t1.getCourses().isEmpty());
    }
}