package com.cource.management.service;

import com.cource.management.Entity.Language;

import java.util.List;
import java.util.Optional;

public interface LanguageService {

        public List<Language> getAllLanguages() ;

        public Optional<Language> getLanguageById(Long id) ;

        public Language createLanguage(Language language);
        public Language updateLanguage(Long id, Language updatedLanguage) ;

        public void deleteLanguage(Long id) ;
}
