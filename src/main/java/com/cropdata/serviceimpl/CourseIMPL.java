package com.cropdata.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropdata.dto.CourseDTO;
import com.cropdata.entity.Course;
import com.cropdata.exception.CourseNotFoundException;
import com.cropdata.iservice.ICourseService;
import com.cropdata.mapper.CourseMapper;
import com.cropdata.repository.CourseRepository;

@Service
public class CourseIMPL implements ICourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CourseMapper courseMapper;

	@Override
	public Course saveCourse(CourseDTO courseDTO) {
		Course course = null;
		try {
			course = courseRepository.save(courseMapper.toCourse(courseDTO));

		} catch (Exception e) {
			e.printStackTrace();
			throw new CourseNotFoundException("Customer Present");
		}
		return course;
	}

	@Override
	public List<Course> getAllCourse() {
		List<Course> courses = new ArrayList<>();
		try {
			courses = courseRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new CourseNotFoundException();
		}
		return courses;
	}

	@Override
	public Course updateCourse(CourseDTO courseDTO) {
		Course course = courseRepository.findById(courseDTO.getCId()).get();
		try {

			if (course.getCId() != null) {

				course = courseRepository.save(courseMapper.toCourse(courseDTO));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CourseNotFoundException();
		}
		return course;
	}

	@Override
	public Course deleteCourseById(Integer cId) {
		Course course = courseRepository.findById(cId).get();
		try {
			if (course.getCId() != null) {
				courseRepository.delete(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CourseNotFoundException();
		}
		return course;
	}

	@Override
	public Course findByCourseId(Integer cId) {
		Course course = new Course();
		try {
			if (cId != null) {
				course = courseRepository.findById(cId).get();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CourseNotFoundException();
		}
		return course;
	}

	@Override
	public Course findByCourseName(String courseName) {
		Course course = new Course();
		try {
			if (courseName != null) {
				course = courseRepository.findByname(courseName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CourseNotFoundException();
		}

		return course;
	}
}
