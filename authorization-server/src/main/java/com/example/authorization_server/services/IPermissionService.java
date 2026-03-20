package com.example.authorization_server.services;

import com.example.authorization_server.model.Permission;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IPermissionService {

    List<Permission> findAll();

    Optional<Permission> findById(Long id);

    Permission save(Permission entity);

    void deleteById(Long id);

    Permission update(Permission entity);

}
