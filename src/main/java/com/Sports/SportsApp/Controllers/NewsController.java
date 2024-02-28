package com.Sports.SportsApp.Controllers;

import com.Sports.SportsApp.Models.News;
import com.Sports.SportsApp.Services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")

public class NewsController {
    private NewsService newsService;
    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }
    @PostMapping
    public ResponseEntity<News> createNews(@RequestBody News news) {
        News createdNews = newsService.createNews(news);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNews);
    }

    @GetMapping("/byMatch/{matchId}")
    public ResponseEntity<List<News>> getNewsByMatchId(@PathVariable Long matchId) {
        List<News> newsList = newsService.getNewsByMatchId(matchId);
        return ResponseEntity.ok(newsList);
    }

    @GetMapping("/byTour/{tourId}")
    public ResponseEntity<List<News>> getNewsByTourId(@PathVariable Long tourId) {
        List<News> newsList = newsService.getNewsByTourId(tourId);
        return ResponseEntity.ok(newsList);
    }

    @GetMapping("/bySport/{sportId}")
    public ResponseEntity<List<News>> getNewsBySportId(@PathVariable Long sportId) {
        List<News> newsList = newsService.getNewsBySportId(sportId);
        return ResponseEntity.ok(newsList);
    }
}
