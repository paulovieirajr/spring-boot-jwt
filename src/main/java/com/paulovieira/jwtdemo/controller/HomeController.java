package com.paulovieira.jwtdemo.controller;

import org.springframework.web.bind.annotation.*;

import java.security.*;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
     public String home(Principal principal) {
         return "Hello, " + principal.getName();
     }
}
