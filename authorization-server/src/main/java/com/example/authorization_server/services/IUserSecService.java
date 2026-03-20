package com.example.authorization_server.services;


import com.example.authorization_server.model.UserSec;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

public interface IUserSecService {

    List<UserSec> findAll();

    Optional<UserSec> findById(Long id);

    UserSec save(UserSec entity);

    void deleteById(Long id);

    void update(UserSec entity);

    String encriptPassword(String password);
}
