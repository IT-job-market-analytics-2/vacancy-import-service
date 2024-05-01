package dev.lxqtpr.linda.vacancyimportservice.dto;

import lombok.Data;

@Data
public class VacancyImportScheduledTaskDto {
    private Integer pageSize;
    private Integer pageNumber;
    private String query;
}
