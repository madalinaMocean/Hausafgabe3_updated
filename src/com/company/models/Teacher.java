package com.company.models;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{

    private List<Course> courses;

    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
        this.courses = new ArrayList<>();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void removeCourse(Course course){
        courses.remove(course);
    }
}
