package com.cource.management.runner;

import com.cource.management.Entity.Writer;
import com.cource.management.repo.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
@Order(1)
public class WriterRunner implements CommandLineRunner {
    @Autowired
    private WriterRepository writerRepository;

    public void run(String... args) {
        List<Writer> list = new LinkedList<>();
        if (writerRepository.count() == 0) {
            list.add(new Writer("vikrant"));
            list.add(new Writer("satya"));
            list.add(new Writer("dhamma"));
        }
        writerRepository.saveAll(list);
    }
}
