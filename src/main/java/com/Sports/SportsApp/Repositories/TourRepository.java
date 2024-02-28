package com.Sports.SportsApp.Repositories;

import com.Sports.SportsApp.Models.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TourRepository extends JpaRepository<Tour,Long> {

    List<Tour> findBySportName(String sportName);
    List<Tour> findBySportId(Long sportId);
}
