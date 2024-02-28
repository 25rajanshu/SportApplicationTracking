package com.Sports.SportsApp.DTO;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Getter
@Setter

@Component

public class MatchDto {
    private Long id;
    private LocalDateTime startTime;
    private String format;

    public MatchDto(Long id, LocalDateTime startTime, String format) {
        this.id = id;
        this.startTime = startTime;
        this.format = format;
    }
}
