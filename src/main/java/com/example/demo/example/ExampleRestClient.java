package com.example.demo.example;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.net.URI;
import java.util.Random;

@Service
@Log4j2
public class ExampleRestClient {

    private final RestClient restClient = RestClient.builder().build();

    public ResponseEntity<String> externalUrlGet() {
        int delay = getRandom3DigitInt();
        log.trace("getting from external url with that replies randomly delayed " + delay + "ms");
        final ResponseEntity<String> entity = restClient.get().uri(URI.create("http://httpstat.us/200?sleep=" + delay)).retrieve()
                .toEntity(String.class);
        return ResponseEntity.ok(entity.getBody() + " RANDOM DELAY WAS " + delay);
    }

    public static int getRandom3DigitInt() {
        Random random = new Random();
        return 100 + random.nextInt(900); // Ensures a 5-digit number (100 to 999)
    }

}
