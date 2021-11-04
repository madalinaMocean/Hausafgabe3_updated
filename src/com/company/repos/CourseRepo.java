package com.company.repos;

import com.company.models.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Course repo.
 */
public class CourseRepo extends InMemoryRepository<Course> {

    private List<Course> courseList = new ArrayList<>();


    @Override
    public List<Course> getAll() {
        return courseList;
    }

    @Override
    public Course create(Course entity) {
        if (courseList.contains(entity)) {
            return null;
        }
        courseList.add(entity);
        return (Course) entity;
    }

    @Override
    public Course delete(Course entity) {
        if(courseList.contains(entity)){
            courseList.remove(entity);
            return entity;
        }
        else return null;
    }

    @Override
    public Course update(Course entity) {
        Course oldEntity = courseList.stream()
                .filter(el-> Objects.equals(el.getCourseName(), entity.getCourseName()))
                .findFirst()
                .get();
        if(courseList.contains(entity)){
            courseList.remove(oldEntity);
            courseList.add(entity);
            return null;
        }
        else return entity;
    }

    /**
     * Available courses list.
     *
     * @return the list
     */
    public List<Course> availableCourses(){
        List<Course> availableCourses = new ArrayList<>();
        for (Course entity:courseList) {
            if(entity.hasAvailableSeats()){
                availableCourses.add(entity);
            }
        }
        return availableCourses;
    }
}
