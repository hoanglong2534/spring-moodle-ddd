package com.onschool.demo.application.service.impl;

import com.onschool.demo.application.dto.request.LoginRequest;
import com.onschool.demo.application.dto.response.LoginResponse;
import com.onschool.demo.application.service.AuthenticationService;
import com.onschool.demo.infrastructure.persistance.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());


        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        User user = (User) authenticate.getPrincipal();
        List<String> roles = user.getRoleAssignmentsList()
                .stream()
                .map(ra -> ra.getRole().getShortName())
                .toList();

        return LoginResponse.builder()
                .accessToken(jwtService.genAccessToken(user))
                .refreshToken(jwtService.genRefreshToken(user))
                .userId(user.getId())
                .role(roles)
                .build();
    }

    @Override
    public String refreshToken(String refreshToken) {
        return "a";
    }
}
