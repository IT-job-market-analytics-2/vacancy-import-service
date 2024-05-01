package dev.lxqtpr.linda.vacancyimportservice.services;

import dev.lxqtpr.linda.vacancyimportservice.dto.VacancyImportScheduledTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumerService {

    private final HHApiService hhApiService;

    @RabbitListener(queues = "${rabbitmq.vacancy_import_scheduled_tasks_queue}")
    public void receiveVacancies(VacancyImportScheduledTaskDto dto){
        hhApiService.query(dto);
    }
}
