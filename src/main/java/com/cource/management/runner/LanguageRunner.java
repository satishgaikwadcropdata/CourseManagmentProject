package com.cource.management.runner;

import com.cource.management.Entity.Language;
import com.cource.management.repo.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
@Order(2)
public class LanguageRunner implements CommandLineRunner {
    @Autowired
    private LanguageRepository languageRepository;

    public void run(String... args) {
        List<Language> list = new LinkedList<>();
        if (languageRepository.count() == 0) {
            list.add(new Language("java"));
            list.add(new Language("python"));
            list.add(new Language("php"));
        }
        languageRepository.saveAll(list);
    }
}
