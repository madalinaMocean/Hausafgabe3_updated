package com.company.models;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private Person courseTeacher;
    private int maxEnrollment;
    private List<Student> studentsEnrolled;
    private int credits;

    public Course(String courseName, Person courseTeacher, int maxEnrollment, int credits) {
        this.courseName = courseName;
        this.courseTeacher = courseTeacher;
        this.maxEnrollment = maxEnrollment;
        this.studentsEnrolled = new ArrayList<>();
        this.credits = credits;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Person getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(Person courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int noAvailableSeats(){
        return maxEnrollment-studentsEnrolled.size();
    }

    public boolean hasAvailableSeats(){
        return maxEnrollment - studentsEnrolled.size() > 0;
    }

    public boolean addStudent(Student student){
        if(studentsEnrolled.contains(student)){
            return false;
        }
        studentsEnrolled.add(student);
        return true;
    }

    public void clearList(){
        studentsEnrolled.clear();
    }

}
