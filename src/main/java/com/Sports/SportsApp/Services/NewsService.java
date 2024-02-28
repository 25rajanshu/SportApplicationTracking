package com.Sports.SportsApp.Services;

import com.Sports.SportsApp.Models.News;
import com.Sports.SportsApp.Repositories.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class NewsService {
    private NewsRepository newsRepository;

    public List<News> getNewsByMatchId(Long matchId) {
        return newsRepository.findByMatchId(matchId);
    }

    public List<News> getNewsByTourId(Long tourId) {
        return newsRepository.findByTourId(tourId);
    }

    public List<News> getNewsBySportId(Long sportId) {
        return newsRepository.findBySportId(sportId);
    }

    public News createNews(News news) {
        return newsRepository.save(news);
    }
}
