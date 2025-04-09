package com.br.amorise.amorisetests.response;

import com.br.amorise.amorisetests.model.User;
import com.br.amorise.amorisetests.model.UserType;

import java.time.LocalDate;

public record UserResponseDTO (
        Long id,
        String nome,
        String email,
        UserType userType,
        LocalDate weedingDate,
        String partner1,
        String partner2
) {
    public UserResponseDTO(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getUserType(),
                user.getWeddingDate(),
                user.getPartner1(),
                user.getPartner2()
        );
    }
}


