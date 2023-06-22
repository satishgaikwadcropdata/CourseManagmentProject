package com.cource.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cource.management.Entity.Language;
import com.cource.management.Exception.CourseNotFoundException;
import com.cource.management.customresponse.CustomResponse;
import com.cource.management.dto.LanguageDto;
import com.cource.management.mapper.LanguageMapper;
import com.cource.management.service.LanguageService;

@RestController
@RequestMapping("/api/v1/languages")
public class LanguageController {

	@Autowired
	private LanguageService languageService;

	@Autowired
	private LanguageMapper languageMapper;

	private String code;

	private Object data;

//    public LanguageController(LanguageService languageService,ModelMapper modelMapper) {
//        this.languageService = languageService;
//        this.modelMapper = modelMapper;
//    }

	@GetMapping
	@PreAuthorize("hasAnyAuthority('ROLE_MANAGER','ROLE_USER')")
	public ResponseEntity<?> getAllLanguages() {
		try {
			List<Language> allLanguages = languageService.getAllLanguages();
			data = allLanguages;
			code = "SUCCESS";
		} catch (CourseNotFoundException courseNotFoundException) {
			code = "DATA_NOT_CREATED";
			data = null;
		} catch (RuntimeException runtimeException) {
			code = "RUNTIME_EXCEPTION";
			data = null;
		} catch (Exception exception) {
			code = "EXCEPTION";
			data = null;
		} finally {
			return CustomResponse.response(code, data);
		}
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_MANAGER','ROLE_USER')")
	public ResponseEntity<?> getLanguageById(@PathVariable final Long id) {
		try {
			Optional<Language> languageById = languageService.getLanguageById(id);
			data = languageById;
			code = "SUCCESS";
		} catch (CourseNotFoundException courseNotFoundException) {
			code = "DATA_NOT_CREATED";
			data = null;
		} catch (RuntimeException runtimeException) {
			code = "RUNTIME_EXCEPTION";
			data = null;
		} catch (Exception exception) {
			code = "EXCEPTION";
			data = null;
		} finally {
			return CustomResponse.response(code, data);
		}
	}

	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_MANAGER')")
	public ResponseEntity<?> createLanguage(@RequestBody LanguageDto languageDto) {
		try {
			Language orderEntity = languageService.createLanguage(languageMapper.toLanguage(languageDto));
			// Language languageById = languageService.createLanguage(language);
			data = orderEntity;
			code = "CREATED";
		} catch (CourseNotFoundException courseNotFoundException) {
			code = "DATA_NOT_CREATED";
			data = null;
		} catch (RuntimeException runtimeException) {
			code = "RUNTIME_EXCEPTION";
			data = null;
		} catch (Exception exception) {
			code = "EXCEPTION";
			data = null;
		} finally {
			return CustomResponse.response(code, data);
		}
	}

	@PostMapping("/save")
	@PreAuthorize("hasAuthority('ROLE_MANAGER')")
	public ResponseEntity<?> createLanguage1(@RequestBody Language languageDto) {
		try {
			Language orderToDto = languageService.createLanguage(languageDto);
			data = orderToDto;
			code = "CREATED";
		} catch (CourseNotFoundException courseNotFoundException) {
			code = "DATA_NOT_CREATED";
			data = null;
		} catch (RuntimeException runtimeException) {
			code = "RUNTIME_EXCEPTION";
			data = null;
		} catch (Exception exception) {
			code = "EXCEPTION";
			data = null;
		} finally {
			return CustomResponse.response(code, data);
		}
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_MANAGER')")
	public ResponseEntity<?> updateLanguage(@PathVariable Long id, @RequestBody Language language) {
		try {
			Language languageById = languageService.updateLanguage(id, language);
			data = languageById;
			code = "SUCCESS";
		} catch (CourseNotFoundException courseNotFoundException) {
			code = "DATA_NOT_CREATED";
			data = null;
		} catch (RuntimeException runtimeException) {
			code = "RUNTIME_EXCEPTION";
			data = null;
		} catch (Exception exception) {
			code = "EXCEPTION";
			data = null;
		} finally {
			return CustomResponse.response(code, data);
		}
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_MANAGER')")
	public ResponseEntity<?> deleteLanguage(@PathVariable Long id) {
		try {
			languageService.deleteLanguage(id);
			data = "language deleted with : " + id;
			code = "SUCCESS";
		} catch (CourseNotFoundException courseNotFoundException) {
			code = "DATA_NOT_CREATED";
			data = null;
		} catch (RuntimeException runtimeException) {
			code = "RUNTIME_EXCEPTION";
			data = null;
		} catch (Exception exception) {
			code = "EXCEPTION";
			data = null;
		} finally {
			return CustomResponse.response(code, data);
		}
	}
}