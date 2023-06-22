package com.cource.management.service;

import com.cource.management.Entity.Writer;

import java.util.List;
import java.util.Optional;

public interface WriterService {
    Optional<Writer> getWriterById(Long id);
    List<Writer> getAllWriters();
    Writer createWriter(Writer writer);
    Writer updateWriter(Long id, Writer writer);
    void deleteWriter(Long id);
}