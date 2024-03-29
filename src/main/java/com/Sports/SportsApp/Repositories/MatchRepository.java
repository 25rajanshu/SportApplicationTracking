package com.Sports.SportsApp.Repositories;

import com.Sports.SportsApp.Models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface MatchRepository extends JpaRepository<Match,Long> {

    List<Match> findByTourId(Long tourId);
    List<Match> findByTour_SportNameAndTour_Name(String sportName, String tourName);
}
