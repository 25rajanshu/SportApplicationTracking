package com.Sports.SportsApp.Services;

import com.Sports.SportsApp.Models.Sport;
import com.Sports.SportsApp.Repositories.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SportService {
    private SportRepository sportRepository;
    @Autowired

    public SportService(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    public Optional<Sport> getSportByName(String name) {
        return sportRepository.findByName(name);
    }
    public List<Sport> getAllSports(){
        return sportRepository.findAll();
    }
    public  Sport getSportById(Long id){
        return sportRepository.findById(id).orElse(null);
    }
}
