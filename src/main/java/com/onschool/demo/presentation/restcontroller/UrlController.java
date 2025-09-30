package com.onschool.demo.presentation.restcontroller;

import com.onschool.demo.application.dto.response.UrlResponseDTO;
import com.onschool.demo.application.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/url")
public class UrlController {

    private final UrlService urlService;

    @GetMapping("/{id}")
    public UrlResponseDTO getUrlById(@PathVariable Long id) {
        return urlService.getUrlById(id);
    }

}
