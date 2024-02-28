package com.Sports.SportsApp.DTO;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter

@Component
public class MatchDetails {
    private Long id;
    private String name;
    private String startTime;
    private String format;
}
