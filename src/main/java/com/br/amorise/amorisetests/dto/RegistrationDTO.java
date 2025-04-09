package com.br.amorise.amorisetests.dto;

import com.br.amorise.amorisetests.model.UserType;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class RegistrationDTO {

    @NotBlank(message = "Name is required!")
    @Size(max = 100, message = "The name must not be more than 100 characters long")
    private String name;

    @NotBlank(message = "E-mail is required!")
    @Email(message = "Invalid E-mail format")
    @Size(max = 250, message = "The E-mail must not be more than 255 characters long")
    private String email;

    @NotBlank(message = "Password is required!")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "The password must contain at least 8 characters, with uppercase letters, lowercase letters, numbers and special characters (@$!%*?&)"
    )
    private String password;

    @NotNull(message = "UserType is required!")
    private UserType userType;

    @Future(message = "WeddingDate must be on the future")
    private LocalDate weddingDate;

    @Size(message = "Partner name too long")
    private String partner1;

    @Size(message = "Partner name too long")
    private String partner2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public LocalDate getWeddingDate() {
        return weddingDate;
    }

    public void setWeddingDate(LocalDate weddingDate) {
            this.weddingDate = weddingDate;
    }

    public String getPartner1() {
        return partner1;
    }

    public void setPartner1(String partner1) {
        this.partner1 = partner1;
    }

    public String getPartner2() {
        return partner2;
    }

    public void setPartner2(String partner2) {
        this.partner2 = partner2;
    }
}
