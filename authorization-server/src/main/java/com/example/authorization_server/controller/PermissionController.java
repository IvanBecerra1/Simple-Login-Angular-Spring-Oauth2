package com.example.authorization_server.controller;


import com.example.authorization_server.model.Permission;
import com.example.authorization_server.services.IPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/permission")
@RequiredArgsConstructor
public class PermissionController {

    private final IPermissionService permissionService;

    @GetMapping
    public ResponseEntity<List<Permission>> findAll(){
        return ResponseEntity.ok(this.permissionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permission> findById(@PathVariable("id") Long id){

        Optional<Permission> permission = this.permissionService.findById(id);

        return permission.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Permission> save(@RequestBody Permission entity){
        return ResponseEntity.ok(this.permissionService.save(entity));
    }
}
