package com.cource.management.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Size(min = 2, max = 15, message = "LanguageDto Name Must be between 2 to 15")
    @NotBlank(message = "LanguageDto Name cannot be blank")
    @Pattern(regexp = "^[A-Z a-z]*$", message = "LanguageDto Name Invalid Input")
    private String name;

    @NonNull
    @Size(min = 0, max = 55, message = "LanguageDto Name Must be between 0 to 55")
    @NotBlank(message = "LanguageDto Name cannot be blank")
    @Pattern(regexp = "^[A-Z a-z]*$", message = "LanguageDto Name Invalid Input")
    private String description;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "fk_languageId")
    private Language language;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "fk_writerId")
    private Writer writer;
}