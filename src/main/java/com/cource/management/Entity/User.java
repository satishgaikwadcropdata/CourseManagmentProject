package com.cource.management.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "usesr_tbl", uniqueConstraints = {@UniqueConstraint(columnNames = "username"), @UniqueConstraint(columnNames = "email")})
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 15, message = "Customer First Name Must be between 3 to 15")
    @Pattern(regexp = "^[A-Z a-z]*$", message = "Invalid Input")
    private String firstName;

    @Size(min = 3, max = 15, message = "Customer First Name Must be between 3 to 15")
    @Pattern(regexp = "^[A-Z a-z]*$", message = "Invalid Input")
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    @NonNull
    private String email;

    @Size(min = 6, max = 120, message = "password Must be between 6 to 120")
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonIgnore
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String firstName, String username, @NonNull String email, String password, Set<Role> roles) {
        this.firstName = firstName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
