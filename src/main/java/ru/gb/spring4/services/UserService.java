package ru.gb.spring4.services;


import lombok.RequiredArgsConstructor;
import ru.gb.spring4.entities.Role;
import ru.gb.spring4.entities.User;
import ru.gb.spring4.repositories.UserRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", username)));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapAccessPermissionsToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapAccessPermissionsToAuthorities(Collection<Role> roles) {

        return roles.stream()
                .map(role -> role.getAccessPermissions())
                .flatMap(Collection::stream).map(accessPermission -> new SimpleGrantedAuthority(accessPermission.getName()))
                .collect(Collectors.toList());
    }
}
