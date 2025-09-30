package com.onschool.demo.application.dto.response;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Data
public class CourseResponseDTO {
    private Long id;
    private String fullname;
    private String shortName;
    private String summary;

    @JsonIgnore
    private Long startdate;

    @JsonIgnore
    private Long enddate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public LocalDate getStartDateAsLocalDate() {
        return convertToLocalDate(startdate);
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public LocalDate getEndDateAsLocalDate() {
        return convertToLocalDate(enddate);
    }

    private LocalDate convertToLocalDate(Long epochSeconds) {
        if (epochSeconds == null || epochSeconds == 0) return null;
        return Instant.ofEpochSecond(epochSeconds)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
