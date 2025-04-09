package com.br.amorise.amorisetests.controller;

import com.br.amorise.amorisetests.dto.LoginDTO;
import com.br.amorise.amorisetests.dto.RegistrationDTO;
import com.br.amorise.amorisetests.model.User;
import com.br.amorise.amorisetests.response.UserResponseDTO;
import com.br.amorise.amorisetests.service.AuthenticationService;
import jakarta.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(
            @RequestBody
            @Valid
            RegistrationDTO registrationDTO) {
        User registeredUser = authenticationService.register(registrationDTO);
        return ResponseEntity.ok(new UserResponseDTO(registeredUser));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginDTO loginDTO) {
        User user = authenticationService.login(loginDTO);
        return ResponseEntity.ok(user);
    }
}
