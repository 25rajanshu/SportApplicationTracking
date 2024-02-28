package com.Sports.SportsApp.Services;

import com.Sports.SportsApp.Models.Match;
import com.Sports.SportsApp.Models.Tour;
import com.Sports.SportsApp.Repositories.TourRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class TourService {
    private TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<Match> getMatchesByTourName(String tourName) {
        List<Tour> tours = tourRepository.findBySportName(tourName);
        return tours.stream()
                .flatMap(tour -> tour.getMatches().stream())
                .collect(Collectors.toList());
    }


    public List<Tour> getToursBySportId(Long sportId) {
        return tourRepository.findBySportId(sportId);
    }

    public Tour getTourById(Long id) {
        return tourRepository.findById(id).orElse(null);
    }

    public List<Tour> getToursBySportName(String sportName) {
        return tourRepository.findBySportName(sportName);
    }

    public List<Match> getMatchesForTour(String tourName) {
        // your logic to get matches for a tour
        return Collections.emptyList();
    }
}
