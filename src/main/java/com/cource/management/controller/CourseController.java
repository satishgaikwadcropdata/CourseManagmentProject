package com.cource.management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cource.management.Entity.Course;
import com.cource.management.Exception.CourseNotFoundException;
import com.cource.management.customresponse.CustomResponse;
import com.cource.management.dto.CourseDto;
import com.cource.management.mapper.CourseMapper;
import com.cource.management.service.CourseService;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
	private final CourseService courseService;

	private String code;

	private Object data;

	@Autowired
	private CourseMapper courseMapper;

	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
	public ResponseEntity<?> getCourseById(@PathVariable Long id) {
		try {
			Course course = courseService.getCourseById(id);
			if (course != null) {
				return ResponseEntity.ok(course);
			}
			data = course;
			code = "SUCCESS";
		} catch (CourseNotFoundException courseNotFoundException) {
			code = "DATA_NOT_CREATED";
			data = null;
		} catch (RuntimeException runtimeException) {
			code = "RUNTIME_EXCEPTION";
			data = null;
		} catch (Exception exception) {
			code = "EXCEPTION";
			data = null;
		} finally {
			return CustomResponse.response(code, data);
		}
	}

	@GetMapping
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
	public ResponseEntity<?> getAllCourses() {
		try {
			List<Course> courses = courseService.getAllCourses();
			data = courses;
			code = "SUCCESS";
		} catch (CourseNotFoundException courseNotFoundException) {
			code = "DATA_NOT_CREATED";
			data = null;
		} catch (RuntimeException runtimeException) {
			code = "RUNTIME_EXCEPTION";
			data = null;
		} catch (Exception exception) {
			code = "EXCEPTION";
			data = null;
		} finally {
			return CustomResponse.response(code, data);
		}
	}

	public ResponseEntity<?> createCourse(@Valid @RequestBody final CourseDto courseDto) {
		try {
			Course courseEntity = courseService.createCourse(courseMapper.toCourse(courseDto));
			// Course courseToDto = courseService.createCourse(courseDto);
			data = courseEntity;
			code = "SUCCESS";
		} catch (CourseNotFoundException courseNotFoundException) {
			code = "DATA_NOT_CREATED";
			data = null;
		} catch (RuntimeException runtimeException) {
			code = "RUNTIME_EXCEPTION";
			data = null;
		} catch (Exception exception) {
			code = "EXCEPTION";
			data = null;
		} finally {
			return CustomResponse.response(code, data);
		}
	}

	@PostMapping()
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> createCourse1(@Valid @RequestBody final CourseDto courseDto) {
		try {
			Course course = courseService.createCourse1(courseMapper.toCourse(courseDto));
			data = course;
			code = "SUCCESS";
		} catch (CourseNotFoundException courseNotFoundException) {
			code = "DATA_NOT_CREATED";
			data = null;
		} catch (RuntimeException runtimeException) {
			code = "RUNTIME_EXCEPTION";
			data = null;
		} catch (Exception exception) {
			code = "EXCEPTION";
			data = null;
		} finally {
			return CustomResponse.response(code, data);
		}
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> updateCourse(@PathVariable final Long id, @Valid @RequestBody final Course course) {
		try {
			Course updatedCourse = courseService.updateCourse(id, course);
			data = updatedCourse;
			code = "SUCCESS";
		} catch (CourseNotFoundException courseNotFoundException) {
			code = "DATA_NOT_CREATED";
			data = null;
		} catch (RuntimeException runtimeException) {
			code = "RUNTIME_EXCEPTION";
			data = null;
		} catch (Exception exception) {
			code = "EXCEPTION";
			data = null;
		} finally {
			return CustomResponse.response(code, data);
		}
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> deleteCourse(@PathVariable final Long id) {
		try {
			courseService.deleteCourse(id);
			data = "course deleted : " + id;
			code = "SUCCESS";
		} catch (CourseNotFoundException courseNotFoundException) {
			code = "DATA_NOT_CREATED";
			data = null;
		} catch (RuntimeException runtimeException) {
			code = "RUNTIME_EXCEPTION";
			data = null;
		} catch (Exception exception) {
			code = "EXCEPTION";
			data = null;
		} finally {
			return CustomResponse.response(code, data);
		}
	}

	@GetMapping("/search")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
	public ResponseEntity<?> searchCourses(@RequestParam(required = false) final String name,
			@RequestParam(required = false) final String[] keywords) {
		List<Course> courses = null;
		try {
			if (name != null) {
				courses = courseService.searchCoursesByName(name);
				return ResponseEntity.ok(courses);
			} else if (keywords != null) {
				courses = courseService.searchCoursesByKeywords(keywords);
				return ResponseEntity.ok(courses);
			}
			data = courses;
			code = "SUCCESS";
		} catch (CourseNotFoundException courseNotFoundException) {
			code = "DATA_NOT_CREATED";
			data = null;
		} catch (RuntimeException runtimeException) {
			code = "RUNTIME_EXCEPTION";
			data = null;
		} catch (Exception exception) {
			code = "EXCEPTION";
			data = null;
		} finally {
			return CustomResponse.response(code, data);
		}
	}
}