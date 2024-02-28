package com.Sports.SportsApp.Controllers;

import com.Sports.SportsApp.DTO.MatchDto;
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

public class MatchControllerIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetMatchesBySportAndTour() {
        // Mock data
        String sportName = "TestSport";
        String tourName = "TestTour";

        // Send a GET request to fetch matches by sport and tour
        ResponseEntity<List<MatchDto>> response = restTemplate.exchange(
                "/sport/tour/match?sportName={sportName}&tourName={tourName}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MatchDto>>() {},
                sportName, tourName);

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        // Additional assertions based on your business logic
    }
}
