package dev.lxqtpr.linda.vacancyimportservice.services;

import dev.lxqtpr.linda.vacancyimportservice.dto.hh.Vacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService {

    @Value("${rabbitmq.vacancies_queue}")
    private String vacanciesQueue;
    private final RabbitTemplate rabbitTemplate;

    public void publishVacancy(Vacancy vacancy){
        rabbitTemplate.convertAndSend(vacanciesQueue, vacancy);
    }
}
