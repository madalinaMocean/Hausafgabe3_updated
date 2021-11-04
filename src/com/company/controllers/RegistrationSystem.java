package com.company.controllers;


import com.company.repos.CourseRepo;
import com.company.models.*;

import java.util.ArrayList;
import java.util.List;

public class RegistrationSystem {
    public CourseRepo courseList= new CourseRepo();

    public boolean register( Course course,Student student){
        if (!course.hasAvailableSeats()){
            System.out.println("Course if fully booked! Try registering to another Course!");
            return false;
        }

        if(course.getStudentsEnrolled().contains(student)){
            System.out.println("Student already registered");
            return false;
        }

        if(!course.addStudent(student) && !student.addCourse(course)){
            System.out.println("Student could not be registered");
            return false;
        }

        System.out.println("Student successfully registered!");
        return true;
    }

    public List<Course> retrieveCoursesWithFreePlaces() {
        List<Course> freePlacesCourses = new ArrayList<>();
        for (Course course : courseList.getAll()) {
            if (course.hasAvailableSeats()) {
                freePlacesCourses.add(course);
            }
        }
        return freePlacesCourses;
    }

    public List<Student> retrieveStudentsEnrolledForACourse(Course course){
        return course.getStudentsEnrolled();
    }

    public List<Course> getAllCourses(){
        return courseList.getAll();
    }

    public boolean deleteCourseByTeacher(Teacher teacher, Course course){
        if (!teacher.getCourses().contains(course)){
            System.out.println("Teacher does not run this course!");
            return false;
        }
        for (Student student:course.getStudentsEnrolled()) {
            student.removeCourse(course);
        }
        course.clearList();
        course.setCourseTeacher(null);
        teacher.removeCourse(course);

        return true;
    }
    //add course to teacher controller function
}

