package com.onschool.demo.application.service.impl;

import com.onschool.demo.application.dto.response.UrlResponseDTO;
import com.onschool.demo.application.service.UrlService;
import com.onschool.demo.infrastructure.persistance.entity.Url;
import com.onschool.demo.infrastructure.persistance.mapper.UrlMapper;
import com.onschool.demo.infrastructure.persistance.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;
    private final UrlMapper urlMapper;
    private final ResourceUrlProvider resourceUrlProvider;

    @Override
    public UrlResponseDTO getUrlById(Long id) {
        Url url = urlRepository.findById(Long.valueOf(id)).orElse(null);
        if (url == null) {
            return null;
        }
        return urlMapper.toDTO(url);
    }


}
