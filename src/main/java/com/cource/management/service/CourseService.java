package com.cource.management.service;

import com.cource.management.Entity.Course;
import com.cource.management.dto.CourseDto;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);
    Course createCourse1(Course course);
    List<Course> getAllCourses();
    Course getCourseById(Long courseId);
    List<Course> searchCoursesByName(String name);
    List<Course> searchCoursesByKeyword(String keyword);
    Course updateCourse(Long courseId, Course updatedCourse);
    void deleteCourse(Long courseId);
    public List<Course> searchCoursesByKeywords(String[] keywords);
}