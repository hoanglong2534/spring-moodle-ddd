package com.onschool.demo.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlResponseDTO {
    private Long id;
    private String name;
    private String intro;
    private String introformat;
    private String parameters;
    private String externalurl;
    private Long display;
}
