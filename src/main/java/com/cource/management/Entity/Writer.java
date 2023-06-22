package com.cource.management.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Size(min = 2, max = 15, message = "Writer Name Must be between 2 to 15")
    @NotBlank(message = "Writer Name cannot be blank")
    @Pattern(regexp = "^[A-Z a-z]*$", message = "Writer Name Invalid Input")
    private String name;

}