package dev.lxqtpr.linda.vacancyimportservice.services;

import dev.lxqtpr.linda.vacancyimportservice.dto.VacancyImportScheduledTaskDto;
import dev.lxqtpr.linda.vacancyimportservice.dto.hh.Vacancies;
import dev.lxqtpr.linda.vacancyimportservice.exceptions.HhApiBadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
@RequiredArgsConstructor
public class HHApiService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ProducerService producerService;

    @Value("${hh.url}")
    private String url;

    public void query(VacancyImportScheduledTaskDto query) {
        log.info("Receive scheduled query: " + query);

        Vacancies vacancies = requestToApi(query);
        log.debug("Returned vacancies count: " + vacancies.getVacancies().size());

        log.debug("Publishing to the queue");
        vacancies.getVacancies().forEach(producerService::publishVacancy);

        log.info("Query handled successfully");
    }

    public Vacancies requestToApi(VacancyImportScheduledTaskDto query) {
        var textQuery  = "NAME:(%s)".formatted(query.getQuery());
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("page", query.getPageNumber())
                .queryParam("per_page", query.getPageSize())
                .queryParam("text", textQuery);

        log.debug("Requesting vacancies from HH API");
        try {
            var response = restTemplate
                    .getForEntity(builder.toUriString(), Vacancies.class);
            log.debug("Request completed successfully");
            return response.getBody();
        } catch (HttpClientErrorException.Forbidden | HttpClientErrorException.BadRequest e) {
            log.error(e.getMessage());
            throw new HhApiBadRequestException(e.getMessage());
        }
    }
}
