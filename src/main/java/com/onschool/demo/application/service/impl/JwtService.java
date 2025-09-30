package com.onschool.demo.application.service.impl;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.onschool.demo.application.dto.response.LoginResponse;
import com.onschool.demo.infrastructure.persistance.entity.User;
import com.onschool.demo.infrastructure.persistance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final UserRepository userRepository;

    private String secretKey = "EoA5VncqTgeRcI5alRXOE8M/JWE+MG1O2pBG02pfaZRZvkKNiN9lY1KjX/jZQiBYmHEw8xKg6jc9kG3cIEdtub6ZM/su56lsQheUvG3avUU=";

    public String genAccessToken(User user) {

        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        Date issuesTime = new Date();
        Date expirationTime = Date.from(issuesTime.toInstant().plus(5, ChronoUnit.MINUTES));

        List<String> roles = user.getRoleAssignmentsList().stream()
                .map(ra -> ra.getRole().getShortName())
                .collect(Collectors.toList());

        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUsername())
                .issueTime(issuesTime)
                .expirationTime(expirationTime)
                .claim("roles", roles)
                .build();

        Payload payload = new Payload(claimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);
        try {
            jwsObject.sign(new MACSigner(secretKey));
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }

        return jwsObject.serialize();
    }

    public String genRefreshToken(User user) {

        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        Date issuesTime = new Date();
        Date expirationTime = Date.from(issuesTime.toInstant().plus(30, ChronoUnit.DAYS));

        List<String> roles = user.getRoleAssignmentsList().stream()
                .map(ra -> ra.getRole().getShortName())
                .collect(Collectors.toList());

        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUsername())
                .issueTime(issuesTime)
                .expirationTime(expirationTime)
                .claim("roles", roles)
                .build();

        Payload payload = new Payload(claimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);
        try {
            jwsObject.sign(new MACSigner(secretKey));
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }

        return jwsObject.serialize();
    }

    public boolean verifyToken(String token) {
        try{
            JWSObject jwsObject = JWSObject.parse(token);

            //chuKy
            if(!jwsObject.verify(new MACVerifier(secretKey))){
                return false;
            }

            JWTClaimsSet claimsSet = JWTClaimsSet.parse(jwsObject.getPayload().toJSONObject());
            Date expirationTime = claimsSet.getExpirationTime();
            Date now = new Date();
            if(expirationTime.before(now)){
                return false;
            }
            return true;

        }catch (Exception e){
            return false;
        }
    }

    public String refreshAccessToken(Map<String, String> data) {
        String refreshToken = data.get("refreshToken");
        String username = data.get("username");

        if (refreshToken == null || username == null) {
            throw new RuntimeException("Missing refreshToken or username");
        }

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!verifyToken(refreshToken)) {
            throw new RuntimeException("Invalid refresh token");
        }

        return genAccessToken(user);
    }

    public LoginResponse generateLoginResponse(User user) {
        List<String> roles = user.getRoleAssignmentsList().stream()
                .map(ra -> ra.getRole().getShortName())
                .toList();

        return LoginResponse.builder()
                .accessToken(genAccessToken(user))
                .refreshToken(genRefreshToken(user))
                .userId(user.getId())
                .role(roles)
                .build();
    }

}
