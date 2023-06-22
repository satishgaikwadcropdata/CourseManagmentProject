package com.cource.management.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class LanguageDto {

    @Hidden
    private Long id;

    @Size(min = 2, max = 15, message = "LanguageDto Name Must be between 2 to 15")
    @NotBlank(message = "LanguageDto Name cannot be blank")
    @Pattern(regexp = "^[A-Z a-z]*$", message = "LanguageDto Name Invalid Input")
    private String name;

}
