package com.cource.management.runner;

import com.cource.management.Entity.Course;
import com.cource.management.Entity.Language;
import com.cource.management.Entity.Writer;
import com.cource.management.repo.CourseRepository;
import com.cource.management.repo.LanguageRepository;
import com.cource.management.repo.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
@Component
@Order(3)
public class CourseRunner implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private WriterRepository writerRepository;

    public void run(String... args) {
        List<Course> list = new LinkedList<>();
        if (courseRepository.count() == 0) {
            list.add(new Course("SpringBoot","Rest Api with SpringBoot",languageRepository.findById(1L).get(),writerRepository.findById(1L).get()));
            list.add(new Course("Django","Rest Api with Django",languageRepository.findById(2L).get(),writerRepository.findById(2L).get()));
            list.add(new Course("Laravel","Rest Api with Laravel",languageRepository.findById(3L).get(),writerRepository.findById(3L).get()));
        }
        courseRepository.saveAll(list);
    }
}
