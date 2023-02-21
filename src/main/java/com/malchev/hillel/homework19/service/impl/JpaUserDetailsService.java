package com.malchev.hillel.homework19.service.impl;

import com.malchev.hillel.homework19.domain.SecurityUser;
import com.malchev.hillel.homework19.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return userRepository
               .findByUserName(username)
               .map(SecurityUser::new)
               .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
    }
}
