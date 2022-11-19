package com.paulovieira.jwtdemo.config;

import org.springframework.boot.context.properties.*;

import java.security.interfaces.*;
@ConfigurationProperties(prefix = "rsa")
public record RsaKeyProperties(RSAPublicKey publicKey, RSAPrivateKey privateKey) {
}
