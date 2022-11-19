package com.paulovieira.jwtdemo.controller;

import com.paulovieira.jwtdemo.service.*;
import org.springframework.security.core.*;
import org.springframework.web.bind.annotation.*;

import java.util.logging.*;

@RestController
public class AuthController {

    private static final Logger LOG = Logger.getLogger(AuthController.class.getName());

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public String token(Authentication authentication) {
        LOG.info("Generating token for " + authentication.getName());

        var token = tokenService.generateToken(authentication);

        LOG.info("Token generated: " + token);

        return token;
    }
}
