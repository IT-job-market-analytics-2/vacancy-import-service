package dev.lxqtpr.linda.vacancyimportservice.services;

import dev.lxqtpr.linda.vacancyimportservice.dto.VacancyImportScheduledTaskDto;
import dev.lxqtpr.linda.vacancyimportservice.dto.hh.Vacancies;
import dev.lxqtpr.linda.vacancyimportservice.exceptions.HhApiBadRequestException;
import dev.lxqtpr.linda.vacancyimportservice.exceptions.HhApiQuotaException;
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
    private final QuotaService quotaService;

    @Value("${hh.url}")
    private String url;


    public void query(VacancyImportScheduledTaskDto query) {
        try {
            quotaService.receivedQuota();
            log.debug("Has quota");

            log.info("Receive scheduled query: " + query);

            Vacancies vacancies = requestToApi(query);
            log.debug("Returned vacancies count: " + vacancies.getVacancies().size());

            log.debug("Publishing to the queue");
            vacancies.getVacancies().forEach(vacancy -> {
                vacancy.setQuery(query.getQuery());
                producerService.publishVacancy(vacancy);
            });

            log.info("Query handled successfully");
        }
        catch (HhApiBadRequestException e) {
            log.warn("Bad request to HH.ru API");
        }
        catch (HhApiQuotaException e) {
            log.warn("We exceeded HH.ru API quot");
        }
        catch (Exception e){
            log.warn("Unknown exception occurred:{}", e.getMessage());
        }
    }

    public Vacancies requestToApi(VacancyImportScheduledTaskDto query) {
        var textQuery  = "NAME:(%s)".formatted(query.getQuery());
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("page", query.getPageIndex())
                .queryParam("per_page", query.getPageSize())
                .queryParam("text", textQuery);

        log.debug("Requesting vacancies from HH API");
        try {
            var response = restTemplate
                    .getForEntity(builder.toUriString(), Vacancies.class);
            log.debug("Request completed successfully");
            return response.getBody();
        } catch (HttpClientErrorException.BadRequest e) {
            log.error(e.getMessage());
            throw new HhApiBadRequestException(e.getMessage());
        }
        catch (HttpClientErrorException.Forbidden e) {
            log.error(e.getMessage());
            throw new HhApiQuotaException(e.getMessage());
        }
    }
}
