package com.example.resource_server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @GetMapping("/menssage")
    public ResponseEntity<String> getWelcome() {
        return ResponseEntity.ok("Bienvenido, get");
    }

    @PostMapping("/menssage")
    public ResponseEntity<String> postWelcome() {
        return ResponseEntity.ok("Bienvenido, post");
    }
}

