package com.example.authorization_server.repository;

import com.example.authorization_server.model.UserSec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSecRepository extends JpaRepository<UserSec, Long> {

    Optional<UserSec> findUserEntityByEmail(String email);
}
