package com.Sports.SportsApp.Repositories;

import com.Sports.SportsApp.Models.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface NewsRepository extends JpaRepository<News,Long> {

    List<News> findByMatchId(Long matchId);
    List<News> findByTourId(Long tourId);
    List<News> findBySportId(Long sportId);
}
