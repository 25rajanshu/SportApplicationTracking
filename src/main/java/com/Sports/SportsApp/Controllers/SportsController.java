package com.Sports.SportsApp.Controllers;

import com.Sports.SportsApp.Models.Sport;
import com.Sports.SportsApp.Services.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/sports")
public class SportsController {
    private SportService sportService;
     @Autowired
    public SportsController(SportService sportService) {
        this.sportService = sportService;
    }
    @GetMapping("/{sportName}")
    public ResponseEntity<Sport> getSportByName(@PathVariable String sportName) {
        Optional<Sport> sport = sportService.getSportByName(sportName);
        return sport.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
