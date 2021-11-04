package com.company.models;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private long studentId;
    private List<Course> enrolledCourses;

    public Student(String firstName, String lastName, long studentId) {
        super(firstName, lastName);
        this.studentId = studentId;
        this.enrolledCourses = new ArrayList<>();
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public boolean addCourse(Course course){
        if(enrolledCourses.contains(course) || totalCredits()>=30){
            return false;
        }

        enrolledCourses.add(course);
        return true;
    }

    public void removeCourse(Course course){
        enrolledCourses.remove(course);
    }

    public int totalCredits() {
        int totalNoCredits = 0;
        for (Course course : enrolledCourses) {
            totalNoCredits+=course.getCredits();
        }
        return totalNoCredits;
    }
}
