package com.onschool.demo.application.service;

import com.onschool.demo.application.dto.request.LoginRequest;
import com.onschool.demo.application.dto.response.LoginResponse;

public interface AuthenticationService {
    LoginResponse login(LoginRequest loginRequest);

}
