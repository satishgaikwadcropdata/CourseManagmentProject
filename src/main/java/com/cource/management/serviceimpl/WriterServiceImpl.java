package com.cource.management.serviceimpl;

import com.cource.management.Entity.Writer;
import com.cource.management.Exception.WriterNotFoundException;
import com.cource.management.repo.WriterRepository;
import com.cource.management.service.WriterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WriterServiceImpl implements WriterService {
    private final WriterRepository writerRepository;

    public WriterServiceImpl(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    @Override
    public Optional<Writer> getWriterById(Long id) {
        return Optional.ofNullable(writerRepository.findById(id).orElseThrow(() -> new WriterNotFoundException()));
    }

    @Override
    public List<Writer> getAllWriters() {
        if (writerRepository.count() != 0) {
            return writerRepository.findAll();
        } else {
            throw new WriterNotFoundException();
        }
    }

    @Override
    public Writer createWriter(Writer writer) {
        return writerRepository.save(writer);
    }

    @Override
    public Writer updateWriter(Long id, Writer writer) {
        Writer writer1 = writerRepository.findById(id).orElseThrow(() -> new WriterNotFoundException());
        return writerRepository.save(writer1);
    }

    @Override
    public void deleteWriter(Long id) {
        Writer writer = writerRepository.findById(id).orElseThrow(() -> new WriterNotFoundException());
        writerRepository.delete(writer);
    }
}