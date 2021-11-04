package com.company.models;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Course.
 */
public class Course {
    private String courseName;
    private Person courseTeacher;
    private int maxEnrollment;
    private List<Student> studentsEnrolled;
    private int credits;

    /**
     * Instantiates a new Course.
     *
     * @param courseName    the course name
     * @param courseTeacher the course teacher
     * @param maxEnrollment the max enrollment
     * @param credits       the credits
     */
    public Course(String courseName, Person courseTeacher, int maxEnrollment, int credits) {
        this.courseName = courseName;
        this.courseTeacher = courseTeacher;
        this.maxEnrollment = maxEnrollment;
        this.studentsEnrolled = new ArrayList<>();
        this.credits = credits;
    }

    /**
     * Gets course name.
     *
     * @return the course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets course name.
     *
     * @param courseName the course name
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets course teacher.
     *
     * @return the course teacher
     */
    public Person getCourseTeacher() {
        return courseTeacher;
    }

    /**
     * Sets course teacher.
     *
     * @param courseTeacher the course teacher
     */
    public void setCourseTeacher(Person courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    /**
     * Gets max enrollment.
     *
     * @return the max enrollment
     */
    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    /**
     * Sets max enrollment.
     *
     * @param maxEnrollment the max enrollment
     */
    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    /**
     * Gets students enrolled.
     *
     * @return the students enrolled
     */
    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    /**
     * Sets students enrolled.
     *
     * @param studentsEnrolled the students enrolled
     */
    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    /**
     * Gets credits.
     *
     * @return the credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Sets credits.
     *
     * @param credits the credits
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * No available seats int.
     *
     * @return the int
     */
    public int noAvailableSeats(){
        return maxEnrollment-studentsEnrolled.size();
    }

    /**
     * Has available seats boolean.
     *
     * @return the boolean
     */
    public boolean hasAvailableSeats(){
        return maxEnrollment - studentsEnrolled.size() > 0;
    }

    /**
     * Add student boolean.
     *
     * @param student the student
     * @return the boolean
     */
    public boolean addStudent(Student student){
        if(studentsEnrolled.contains(student)){
            return false;
        }
        studentsEnrolled.add(student);
        return true;
    }

    /**
     * Clear list.
     */
    public void clearList(){
        studentsEnrolled.clear();
    }

}
