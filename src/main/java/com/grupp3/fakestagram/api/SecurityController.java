package com.grupp3.fakestagram.api;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/security")
public class SecurityController {

    @GetMapping("/")
    public String currentUsername(Authentication authentication) {
        return authentication.getName();
    }
}
