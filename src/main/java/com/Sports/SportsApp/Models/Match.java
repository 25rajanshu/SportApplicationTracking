package com.Sports.SportsApp.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter

public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startTime;
    private String format;
    // other fields

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

}
