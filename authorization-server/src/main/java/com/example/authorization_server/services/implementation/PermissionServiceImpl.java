package com.example.authorization_server.services.implementation;


import com.example.authorization_server.model.Permission;
import com.example.authorization_server.repository.PermissionRepository;
import com.example.authorization_server.services.IPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements IPermissionService {

    private final PermissionRepository repository;

    @Override
    public List<Permission> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Permission> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Permission save(Permission entity) {
        return this.repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Permission update(Permission entity) {
        return this.repository.save(entity);
    }
}
