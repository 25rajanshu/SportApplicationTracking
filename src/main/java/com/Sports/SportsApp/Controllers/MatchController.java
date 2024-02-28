package com.Sports.SportsApp.Controllers;

import com.Sports.SportsApp.DTO.MatchDto;
import com.Sports.SportsApp.Models.Match;
import com.Sports.SportsApp.Repositories.MatchRepository;
import com.Sports.SportsApp.Services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/sport/tour/match")

public class MatchController {
    private MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService= matchService;
    }


    @GetMapping
    public ResponseEntity<List<MatchDto>> getMatchesBySportAndTour(
            @RequestParam String sportName,
            @RequestParam String tourName) {
        List<Match> matches = matchService.getMatchesBySportAndTour(sportName, tourName);

        List<MatchDto> matchDtos = matches.stream()
                .map(match -> new MatchDto(match.getId(), match.getStartTime(), match.getFormat()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(matchDtos);
    }
}
