package com.example.authorization_server.services.implementation;

import com.example.authorization_server.model.UserSec;
import com.example.authorization_server.repository.UserSecRepository;
import com.example.authorization_server.services.IUserSecService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserSecServiceImpl implements IUserSecService {

    private final UserSecRepository repository;

    @Override
    public List<UserSec> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<UserSec> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public UserSec save(UserSec entity) {
        return this.repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public void update(UserSec entity) {
        this.repository.save(entity);
    }

    @Override
    public String encriptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
