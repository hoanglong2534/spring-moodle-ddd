package com.onschool.demo.application.service;

import com.onschool.demo.application.dto.response.UrlResponseDTO;

public interface UrlService {
    UrlResponseDTO getUrlById(Long id);

}