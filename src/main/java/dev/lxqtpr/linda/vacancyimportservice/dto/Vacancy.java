package dev.lxqtpr.linda.vacancyimportservice.dto;

import lombok.Data;

@Data
public class Vacancy {
    private String id;
    private String name;
    private Area area;
    private Salary salary;
    private Type type;
    private Object responseUrl;
    private String publishedAt;
    private String createdAt;
    private Boolean archived;
    private String alternateUrl;
    private Employer employer;
    private Snippet snippet;
    private Experience experience;
    private Employment employment;
}
