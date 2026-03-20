package com.example.resource_server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/admin")
public class AdminController {

    @GetMapping
    public ResponseEntity<String> okAdmin(Authentication authentication) {
        return ResponseEntity.ok("GET ADMIN, AUTHORITIES: " + authentication.getAuthorities());
    }
}
