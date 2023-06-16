package com.cropdata.iservice;

import java.util.List;

import com.cropdata.dto.CourseDTO;
import com.cropdata.entity.Course;

public interface ICourseService {

	public Course saveCourse(CourseDTO courseDTO);

	public List<Course> getAllCourse();

	public Course updateCourse(CourseDTO courseDTO);

	public Course deleteCourseById(Integer cId);

	public Course findByCourseId(Integer cId);

	public Course findByCourseName(String courseName);

}
