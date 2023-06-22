package com.cource.management.repo;

import com.cource.management.Entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
