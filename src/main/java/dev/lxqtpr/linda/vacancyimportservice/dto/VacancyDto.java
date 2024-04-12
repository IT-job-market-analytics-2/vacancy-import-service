package dev.lxqtpr.linda.vacancyimportservice.dto;

import lombok.Data;

import java.awt.geom.Area;

@Data
public class VacancyDto {
    private String id;
    private String name;
    private Area area;
    private SalaryDto salary;
    private TypeDto type;
    private Object responseUrl;
    private String publishedAt;
    private String createdAt;
    private Boolean archived;
    private String alternateUrl;
    private EmployerDto employer;
    private SnippetDto snippet;
    private ExperienceDto experience;
    private EmploymentDto employment;
}
