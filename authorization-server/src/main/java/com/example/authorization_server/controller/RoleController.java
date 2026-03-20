package com.example.authorization_server.controller;


import com.example.authorization_server.model.Permission;
import com.example.authorization_server.model.Role;
import com.example.authorization_server.services.IPermissionService;
import com.example.authorization_server.services.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/v1/api/role")
@RequiredArgsConstructor
public class RoleController {

    private final IRoleService roleService;
    private final IPermissionService permissionService;

    @GetMapping
    public ResponseEntity<List<Role>> findAll(){
        return ResponseEntity.ok(this.roleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> findById(@PathVariable("id") Long id) {
        Optional<Role> role = this.roleService.findById(id);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Role> save(@RequestBody Role entity) {

        Set<Permission> list = new HashSet<>();
        Permission readPermission;

        /**
         * Re-codificar aplicando Lambdas
         */
        for (Permission p : entity.getPermissions()) {
            readPermission = this.permissionService.findById(p.getId())
                    .orElse(null);

            if (readPermission != null) {
                list.add(readPermission);
            }
        }

        entity.setPermissions(list);
        return ResponseEntity.ok(this.roleService.save(entity));
    }

}
