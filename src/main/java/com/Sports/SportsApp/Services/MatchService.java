package com.Sports.SportsApp.Services;

import com.Sports.SportsApp.DTO.MatchDetails;
import com.Sports.SportsApp.Models.Match;
import com.Sports.SportsApp.Repositories.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service

public class MatchService {
    private MatchRepository matchRepository;


    public List<Match> getMatchesBySportAndTour(String sportName, String tourName) {
        return matchRepository.findByTour_SportNameAndTour_Name(sportName, tourName);
    }

    public List<MatchDetails> getMatchesDetails(String sportName, String tourName) {
        // your logic to get match details
        return Collections.emptyList();
    }
}
