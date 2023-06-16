package com.cropdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cropdata.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	public Course findByname(String courseName);

}
