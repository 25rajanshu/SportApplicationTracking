package com.Sports.SportsApp.Repositories;

import com.Sports.SportsApp.Models.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface SportRepository extends JpaRepository<Sport,Long> {
    Optional<Sport> findByName(String name);
}
