package com.cource.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cource.management.Entity.Course;
import com.cource.management.Entity.Language;
import com.cource.management.Entity.Writer;
import com.cource.management.Exception.CourseNotFoundException;
import com.cource.management.Exception.LanguageNotFoundException;
import com.cource.management.Exception.WriterNotFoundException;
import com.cource.management.repo.CourseRepository;
import com.cource.management.service.CourseService;
import com.cource.management.service.LanguageService;
import com.cource.management.service.WriterService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private LanguageService languageService;

	@Autowired
	private WriterService writerService;

//	public CourseServiceImpl(CourseRepository courseRepository, LanguageService languageService,
//			WriterService writerService, ModelMapper modelMapper) {
//		this.courseRepository = courseRepository;
//		this.languageService = languageService;
//		this.writerService = writerService;
//		this.modelMapper = modelMapper;
//	}

	@Override
	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course createCourse1(Course course) {
		// Course course =new Course();
		Writer writer = writerService.getWriterById(course.getWriter().getId())
				.orElseThrow(() -> new WriterNotFoundException());
		Language language = languageService.getLanguageById(course.getLanguage().getId())
				.orElseThrow(() -> new LanguageNotFoundException());
		course.setName(course.getName());
		course.setDescription(course.getDescription());
		course.setWriter(writer);
		course.setLanguage(language);
		Course Entity = courseRepository.save(course);
		return Entity;
	}

	@Override
	public List<Course> getAllCourses() {
		if (courseRepository.count() != 0) {
			return courseRepository.findAll();
		} else {
			throw new CourseNotFoundException();
		}
	}

	@Override
	public Course getCourseById(Long courseId) {
		return courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException());
	}

	@Override
	public List<Course> searchCoursesByName(String name) {
		return courseRepository.findByNameContainingIgnoreCase(name);
	}

	@Override
	public List<Course> searchCoursesByKeyword(String keyword) {
		return courseRepository.findByDescriptionContainingIgnoreCase(keyword);
	}

	@Override
	public List<Course> searchCoursesByKeywords(String[] keywords) {
		return courseRepository.findByDescriptionContainingIgnoreCase(String.join(" ", keywords));
	}

	@Override
	public Course updateCourse(Long courseId, Course updatedCourse) {
		Course course = courseRepository.findById(courseId).orElseThrow(CourseNotFoundException::new);
		course.setName(updatedCourse.getName());
		course.setLanguage(updatedCourse.getLanguage());
		course.setDescription(updatedCourse.getDescription());
		Course course1 = courseRepository.save(course);
		return course1;
	}

	@Override
	public void deleteCourse(Long courseId) {
		Course course = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException());
		courseRepository.delete(course);
	}
}
