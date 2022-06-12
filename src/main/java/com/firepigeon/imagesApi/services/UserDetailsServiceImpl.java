package com.firepigeon.imagesApi.services;

import com.firepigeon.imagesApi.documents.Account;
import com.firepigeon.imagesApi.repositories.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountsRepository accountsRepository;

    private static List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(final List<String> roles) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
        return authorities;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountsRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User [" + username + "] not found"));
        return new User(account.getUsername(), account.getPassword(), buildSimpleGrantedAuthorities(account.getRoles()));
    }
}
