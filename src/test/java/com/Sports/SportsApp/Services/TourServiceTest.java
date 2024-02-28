package com.Sports.SportsApp.Services;

import com.Sports.SportsApp.Models.Match;
import com.Sports.SportsApp.Models.Tour;
import com.Sports.SportsApp.Repositories.TourRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TourServiceTest {
    private TourRepository tourRepository;
    @InjectMocks
    private TourService tourService;

    @Test
    public void testGetMatchesByTourName() {
        // Mock data
        String tourName = "TestTour";
        Tour tour = new Tour();
        tour.setName(tourName);
        List<Match> matches = Arrays.asList(new Match(), new Match());

        // Mock repository behavior
        when(tourRepository.findBySportName(tourName)).thenReturn(Collections.singletonList(tour));

        // Test the service method
        List<Match> result = tourService.getMatchesByTourName(tourName);

        // Assertions
        assertEquals(matches.size(), result.size());
        // Additional assertions based on your business logic
    }
}
