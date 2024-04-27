package dev.lxqtpr.linda.vacancyimportservice.services;

import dev.lxqtpr.linda.vacancyimportservice.exceptions.HhApiQuotaException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class QuotaService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${rate-limiter.url}")
    private String rateLimiterUrl;

    public void receivedQuota(){
        log.info("Try to receive quota from rate limiter");
        var res = restTemplate.getForEntity(rateLimiterUrl, String.class);
        if (res.getStatusCode() != HttpStatus.OK) throw new HhApiQuotaException("Hh api has a rate limit");
    }
}
