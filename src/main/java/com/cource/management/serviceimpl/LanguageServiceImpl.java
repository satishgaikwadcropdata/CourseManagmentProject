package com.cource.management.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cource.management.Entity.Language;
import com.cource.management.Exception.LanguageNotFoundException;
import com.cource.management.repo.LanguageRepository;
import com.cource.management.service.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService {

	private final LanguageRepository languageRepository;

	public LanguageServiceImpl(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	public List<Language> getAllLanguages() {
		if (languageRepository.count() != 0) {
			return languageRepository.findAll();
		} else {
			throw new LanguageNotFoundException();
		}
	}

	public Optional<Language> getLanguageById(Long id) {
		return Optional.ofNullable(languageRepository.findById(id).orElseThrow(() -> new LanguageNotFoundException()));
	}

	public Language createLanguage(Language language) {
		return languageRepository.save(language);
	}

	public Language updateLanguage(Long id, Language updatedLanguage) {
		Language language = languageRepository.findById(id).orElseThrow(() -> new LanguageNotFoundException());
		language.setName(updatedLanguage.getName());
		return languageRepository.save(language);
	}

	public void deleteLanguage(Long id) {
		Language language = languageRepository.findById(id).orElseThrow(() -> new LanguageNotFoundException());
		languageRepository.delete(language);
	}
}
