package com.Sports.SportsApp.Controllers;


import com.Sports.SportsApp.Models.News;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class NewsControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateNews() {
        // Mock data
        News news = new News();
        news.setTitle("Test Title");
        news.setDescription("Test Description");

        // Send a POST request to create news
        ResponseEntity<News> response = restTemplate.postForEntity("/news", news, News.class);

        // Assertions
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        // Additional assertions based on your business logic
    }

    @Test
    public void testGetNewsByMatchId() {
        // Mock data
        Long matchId = 1L;

        // Send a GET request to fetch news by match ID
        ResponseEntity<List<News>> response = restTemplate.exchange(
                "/news/byMatch/{matchId}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<News>>() {},
                matchId);

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        // Additional assertions based on your business logic
    }

}
