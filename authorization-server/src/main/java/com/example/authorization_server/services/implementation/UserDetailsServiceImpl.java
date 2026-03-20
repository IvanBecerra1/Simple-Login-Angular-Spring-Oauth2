package com.example.authorization_server.services.implementation;


import com.example.authorization_server.model.UserSec;
import com.example.authorization_server.repository.UserSecRepository;
import com.example.authorization_server.services.IUserSecService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserSecRepository userSecRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserSec userSec = this.userSecRepository.findUserEntityByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User name/mail not found"));

        List<GrantedAuthority> authorityList = new ArrayList<>();

        userSec.getRolesList()
                .forEach(role ->
                        authorityList.add(
                                new SimpleGrantedAuthority("ROLE_".concat(role.getRole()))
                        ));

        userSec.getRolesList().stream()
                .flatMap(role -> role.getPermissions().stream())
                .forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getName())));


        return new User(userSec.getEmail(),
                userSec.getPassword(),
                userSec.isEnabled(),
                userSec.isAccountNotExiperd(),
                userSec.isCredentialNotExpired(),
                userSec.isAccountNotLocked(),
                authorityList);
    }
}
