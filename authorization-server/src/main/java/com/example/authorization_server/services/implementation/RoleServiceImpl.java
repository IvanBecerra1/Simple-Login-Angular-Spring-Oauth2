package com.example.authorization_server.services.implementation;

import com.example.authorization_server.model.Role;
import com.example.authorization_server.repository.RoleRepository;
import com.example.authorization_server.services.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {

    private final RoleRepository repository;

    @Override
    public List<Role> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Role save(Role entity) {
        return this.repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Role update(Role role) {
        return this.repository.save(role);
    }
}
