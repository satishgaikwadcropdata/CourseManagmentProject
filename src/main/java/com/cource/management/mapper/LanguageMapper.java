package com.cource.management.mapper;

import org.mapstruct.Mapper;

import com.cource.management.Entity.Language;
import com.cource.management.dto.LanguageDto;

@Mapper(componentModel = "spring")
public interface LanguageMapper {

	public Language toLanguage(LanguageDto languageDTO);

//	@Mapping(source = "LId", target = "LId")
//	@Mapping(source = "courses", target = "coursesDTO")
	public LanguageDto toLanguageDTO(Language language);
}
