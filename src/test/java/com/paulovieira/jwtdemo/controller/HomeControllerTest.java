package com.paulovieira.jwtdemo.controller;

import com.paulovieira.jwtdemo.config.*;
import com.paulovieira.jwtdemo.service.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.context.annotation.*;
import org.springframework.security.test.context.support.*;
import org.springframework.test.web.servlet.*;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest({HomeController.class, AuthController.class})
@Import({SecurityConfig.class, TokenService.class})
class HomeControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void rootWhenNotAuthenticatedShouldReturn401() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void rootWhenAuthenticatedShouldReturnHelloUser() throws Exception {
        var result = this.mvc.perform(post("/token")
                .with(httpBasic("user", "pass")))
                .andExpect(status().isOk())
                .andReturn();

        var token = result.getResponse().getContentAsString();

        this.mvc.perform(get("/")
                .header("Authorization", "Bearer " + token))
                .andExpect(content().string("Hello, user"));
    }

    @Test
    @WithMockUser
    void rootWithMockUserStatusIsOk() throws Exception {
        this.mvc.perform(get("/"))
                .andExpect(status().isOk());
    }

}