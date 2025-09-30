package com.onschool.demo.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModuleResponseDTO {
    private Long id;
    private String name;
    private String urlName;
    private String details;
    private String moduleType;
    private Long instanceId;
    private Integer visible;
    private Long cron;
    private Long lastcron;
    private String search;
}
