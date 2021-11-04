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

    Teacher teacher1 = new Teacher("Dan", "Doe");
    Teacher teacher2 = new Teacher("Mary", "Jane");

    Course course1 = new Course("APM", teacher1, 1, 6);
    Course course2 = new Course("DSA", teacher2, 3, 6);

    Student student1 = new Student("James", "Blonde", 1);
    Student student2 = new Student("Jane", "Flower", 1);

    @Test
    void register() {
        assert(registrationSystem.register(course1,student1));
        assert(!registrationSystem.register(course1,student2));
        assert(!registrationSystem.register(course1,student1));
    }

    @Test
    void retrieveCoursesWithFreePlaces() {
        assert(registrationSystem.retrieveCoursesWithFreePlaces().isEmpty());
        registrationSystem.courseList.create(course1);
        registrationSystem.register(course1,student1);
        assert(registrationSystem.retrieveCoursesWithFreePlaces().isEmpty());
        registrationSystem.courseList.create(course2);
        assert(registrationSystem.retrieveCoursesWithFreePlaces().size()==1);
    }

    @Test
    void retrieveStudentsEnrolledForACourse() {
        registrationSystem.courseList.create(course1);
        registrationSystem.register(course1,student1);
        assert(registrationSystem.retrieveStudentsEnrolledForACourse(course1).size()==1);
    }

    @Test
    void getAllCourses() {
        registrationSystem.courseList.create(course1);
        registrationSystem.courseList.create(course2);
        assert(registrationSystem.getAllCourses().size()==2);
    }

    @Test
    void deleteCourseByTeacher() {
        registrationSystem.courseList.create(course1); // add course to registration
        registrationSystem.register(course1,student1);
        List<Course> t1c = new ArrayList<Course>();
        t1c.add(course1);
        teacher1.setCourses(t1c);
        assert(!teacher1.getCourses().isEmpty());
        registrationSystem.deleteCourseByTeacher(teacher1, course1);
        assert(teacher1.getCourses().isEmpty());
    }
}