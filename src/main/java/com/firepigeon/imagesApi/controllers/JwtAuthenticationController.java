package com.firepigeon.imagesApi.controllers;

import com.firepigeon.imagesApi.configurations.security.CustomAuthenticationManager;
import com.firepigeon.imagesApi.configurations.security.JwtTokenUtil;
import com.firepigeon.imagesApi.dto.JwtRequest;
import com.firepigeon.imagesApi.dto.JwtResponse;
import com.firepigeon.imagesApi.services.AccountsService;
import com.firepigeon.imagesApi.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtAuthenticationController {
    private final CustomAuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final AccountsService accountsService;
    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public JwtAuthenticationController(CustomAuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, AccountsService accountsService, UserDetailsServiceImpl userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.accountsService = accountsService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws AuthenticationException {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authentication.getPrincipal().toString());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
