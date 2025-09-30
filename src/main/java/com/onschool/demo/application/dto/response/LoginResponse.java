package com.onschool.demo.application.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LoginResponse {
    private String accessToken;
    private String refreshToken;
    private Long userId;
    private List<String> role;
}
