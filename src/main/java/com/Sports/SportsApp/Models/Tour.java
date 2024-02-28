package com.Sports.SportsApp.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Entity

public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JoinColumn(name = "sport_id")
    private Sport sport;

    @OneToMany(mappedBy = "tour")
    private List<Match> matches;


}
