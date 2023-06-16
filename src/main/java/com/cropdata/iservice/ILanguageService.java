package com.cropdata.iservice;

import java.util.List;

import com.cropdata.dto.LanguageDTO;
import com.cropdata.entity.Language;

public interface ILanguageService {

	public Language saveLanguage(LanguageDTO languageDTO);

	public List<Language> getAllLanguage();

	public Language deleteLanguageById(Integer lId);

	public Language updateLanguage(LanguageDTO languageDTO);

	public Language findByCourseId(Integer cId);

}
