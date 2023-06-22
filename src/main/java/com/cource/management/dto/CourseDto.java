package com.cource.management.dto;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class CourseDto {

    @Hidden
    private Long id;

    @Size(min = 2, max = 15, message = "LanguageDto Name Must be between 2 to 15")
    @NotBlank(message = "LanguageDto Name cannot be blank")
    @Pattern(regexp = "^[A-Z a-z]*$", message = "LanguageDto Name Invalid Input")
    private String name;

    @Size(min = 0, max = 55, message = "LanguageDto Name Must be between 0 to 55")
    @NotBlank(message = "LanguageDto Name cannot be blank")
    @Pattern(regexp = "^[A-Z a-z]*$", message = "LanguageDto Name Invalid Input")
    private String description;

    private Long languageid;

    private Long writerid;

    @Hidden
    private LanguageDto language;

    @Hidden
    private WriterDto writer;
}