package dev.lxqtpr.linda.vacancyimportservice.dto;

import lombok.Data;

@Data
public class VacancyImportScheduledTaskDto {
    private int pageSize;
    private int pageIndex;
    private String query;
}
