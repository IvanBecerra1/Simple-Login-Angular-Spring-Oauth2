package com.example.authorization_server.controller;


import com.example.authorization_server.model.Role;
import com.example.authorization_server.model.UserSec;
import com.example.authorization_server.services.IRoleService;
import com.example.authorization_server.services.IUserSecService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/user")
public class UserSecController {

    private final IUserSecService userSecService;
    private final IRoleService roleService;

    public UserSecController(IUserSecService userSecService, IRoleService roleService) {

        this.userSecService = userSecService;
        this.roleService = roleService;
    }

    // http:localhost:8080/v1/user

    @GetMapping()
    public ResponseEntity<List<UserSec>> findAll(){
        return ResponseEntity.ok(this.userSecService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserSec> findById(@PathVariable ("id") Long id) {
        Optional<UserSec> optional = this.userSecService.findById(id);

        return optional.map(ResponseEntity::ok).orElseGet( () -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserSec> save(@RequestBody UserSec entity) {
        HashSet<Role> list = new HashSet<>();
        Role readRole;

        if (entity.getRolesList().isEmpty())
            return ResponseEntity.ofNullable(new UserSec());

        entity.setPassword(this.userSecService.encriptPassword(entity.getPassword()));
        
        for (Role r : entity.getRolesList()) {
            readRole = this.roleService.findById(r.getId()).orElse(null);

            if (readRole == null)
                continue;

            list.add(readRole);
        }

        entity.setRolesList(list);
        return ResponseEntity.ok(this.userSecService.save(entity));
    }
}
