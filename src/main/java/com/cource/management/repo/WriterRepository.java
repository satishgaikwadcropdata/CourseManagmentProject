package com.cource.management.repo;

import com.cource.management.Entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface WriterRepository extends JpaRepository<Writer, Long> {
}