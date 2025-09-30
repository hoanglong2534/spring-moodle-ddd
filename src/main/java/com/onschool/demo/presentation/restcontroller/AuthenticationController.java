package com.onschool.demo.presentation.restcontroller;

import com.onschool.demo.application.dto.request.LoginRequest;
import com.onschool.demo.application.dto.response.LoginResponse;
import com.onschool.demo.application.service.AuthenticationService;
import com.onschool.demo.application.service.impl.JwtService;
import com.onschool.demo.infrastructure.persistance.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final JwtService jwtService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return authenticationService.login(loginRequest);
    }

    @PostMapping("/verify")
    public ResponseEntity<Boolean> verify(@RequestBody String token) {
        return ResponseEntity.ok(jwtService.verifyToken(token));
    }

    @PostMapping("/refresh")
    public ResponseEntity<String> refresh(@RequestBody Map<String, String> request) {
        try {
            String newAccessToken = jwtService.refreshAccessToken(request);
            return ResponseEntity.ok(newAccessToken);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

}
