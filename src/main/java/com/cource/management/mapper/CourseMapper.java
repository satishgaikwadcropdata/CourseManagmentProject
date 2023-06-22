package com.cource.management.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cource.management.Entity.Course;
import com.cource.management.dto.CourseDto;

@Mapper(componentModel = "spring", uses = { LanguageMapper.class, WriterMapper.class })
public interface CourseMapper {

	public Course toCourse(CourseDto courseDTO);

	@Mapping(source = "writer", target = "writer")
	@Mapping(source = "language", target = "language")
	public CourseDto toCourseDTO(Course course);
}
