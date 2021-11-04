package com.company.models;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Student.
 */
public class Student extends Person{
    private long studentId;
    private List<Course> enrolledCourses;

    /**
     * Instantiates a new Student.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param studentId the student id
     */
    public Student(String firstName, String lastName, long studentId) {
        super(firstName, lastName);
        this.studentId = studentId;
        this.enrolledCourses = new ArrayList<>();
    }

    /**
     * Gets student id.
     *
     * @return the student id
     */
    public long getStudentId() {
        return studentId;
    }

    /**
     * Sets student id.
     *
     * @param studentId the student id
     */
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    /**
     * Gets enrolled courses.
     *
     * @return the enrolled courses
     */
    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    /**
     * Sets enrolled courses.
     *
     * @param enrolledCourses the enrolled courses
     */
    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    /**
     * Add course boolean.
     *
     * @param course the course
     * @return the boolean
     */
    public boolean addCourse(Course course){
        if(enrolledCourses.contains(course) || totalCredits()>=30){
            return false;
        }

        enrolledCourses.add(course);
        return true;
    }

    /**
     * Remove course.
     *
     * @param course the course
     */
    public void removeCourse(Course course){
        enrolledCourses.remove(course);
    }

    /**
     * Total credits int.
     *
     * @return the int
     */
    public int totalCredits() {
        int totalNoCredits = 0;
        for (Course course : enrolledCourses) {
            totalNoCredits+=course.getCredits();
        }
        return totalNoCredits;
    }
}
