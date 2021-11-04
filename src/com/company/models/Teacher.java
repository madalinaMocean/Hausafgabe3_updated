package com.company.models;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Teacher.
 */
public class Teacher extends Person{

    private List<Course> courses;

    /**
     * Instantiates a new Teacher.
     *
     * @param firstName the first name
     * @param lastName  the last name
     */
    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
        this.courses = new ArrayList<>();
    }

    /**
     * Gets courses.
     *
     * @return the courses
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Sets courses.
     *
     * @param courses the courses
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * Remove course.
     *
     * @param course the course
     */
    public void removeCourse(Course course){
        courses.remove(course);
    }
}
