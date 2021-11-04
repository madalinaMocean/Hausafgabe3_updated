package com.company.controllers;


import com.company.repos.CourseRepo;
import com.company.models.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Registration system.
 */
public class RegistrationSystem {
    /**
     * The Course list.
     */
    public CourseRepo courseList= new CourseRepo();

    /**
     * Register boolean.
     *
     * @param course  the course
     * @param student the student
     * @return the boolean
     */
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

    /**
     * Retrieve courses with free places list.
     *
     * @return the list
     */
    public List<Course> retrieveCoursesWithFreePlaces() {
        List<Course> freePlacesCourses = new ArrayList<>();
        for (Course course : courseList.getAll()) {
            if (course.hasAvailableSeats()) {
                freePlacesCourses.add(course);
            }
        }
        return freePlacesCourses;
    }

    /**
     * Retrieve students enrolled for a course list.
     *
     * @param course the course
     * @return the list
     */
    public List<Student> retrieveStudentsEnrolledForACourse(Course course){
        return course.getStudentsEnrolled();
    }

    /**
     * Get all courses list.
     *
     * @return the list
     */
    public List<Course> getAllCourses(){
        return courseList.getAll();
    }

    /**
     * Delete course by teacher boolean.
     *
     * @param teacher the teacher
     * @param course  the course
     * @return the boolean
     */
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

