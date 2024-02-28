package com.Sports.SportsApp.Controllers;

import com.Sports.SportsApp.Models.Match;
import com.Sports.SportsApp.Models.Tour;
import com.Sports.SportsApp.Services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tours")

public class TourController {
    private TourService tourService;
    @Autowired

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/matches")
    public ResponseEntity<List<Match>> getMatchesByTourName(@RequestParam String tourName) {
        List<Match> matches = tourService.getMatchesByTourName(tourName);
        return ResponseEntity.ok(matches);
    }
    @GetMapping("/{sportName}")
    public ResponseEntity<List<Tour>> getToursBySportName(@PathVariable String sportName) {
        List<Tour> tours = tourService.getToursBySportName(sportName);
        return ResponseEntity.ok(tours);
    }
}
