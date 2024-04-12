package dev.lxqtpr.linda.vacancyimportservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class VacanciesDto {
    private List<VacancyDto> vacancies;
    private Integer found;
    private Integer pages;
    private Integer perPage;
    private Integer page;
    private Object clusters;
    private Object arguments;
    private String alternateUrl;
}
