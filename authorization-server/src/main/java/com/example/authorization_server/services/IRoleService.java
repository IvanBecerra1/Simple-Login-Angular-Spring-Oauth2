package com.example.authorization_server.services;

import com.example.authorization_server.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    List<Role> findAll();

    Optional<Role> findById(Long id);

    Role save(Role entity);

    void deleteById(Long id);

    Role update(Role role);
}
