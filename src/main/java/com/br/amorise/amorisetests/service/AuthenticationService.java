package com.br.amorise.amorisetests.service;

import com.br.amorise.amorisetests.dto.LoginDTO;
import com.br.amorise.amorisetests.dto.RegistrationDTO;
import com.br.amorise.amorisetests.model.User;
import com.br.amorise.amorisetests.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(RegistrationDTO registrationDTO) {
        if (userRepository.existsByEmail(registrationDTO.getEmail())) {
            throw new RuntimeException("E-mail already taken!");
        }

        User user = new User();

        user.setName(registrationDTO.getName());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        user.setUserType(registrationDTO.getUserType());
        user.setWeddingDate(registrationDTO.getWeddingDate());
        user.setPartner1(registrationDTO.getPartner1());
        user.setPartner2(registrationDTO.getPartner2());

        return userRepository.save(user);
    }

    public User login(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail()).orElseThrow(() -> new RuntimeException("Email not found"));
        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new RuntimeException("Wrong password!");
        }
        return user;
    }
}
