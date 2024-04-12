package dev.lxqtpr.linda.vacancyimportservice.dto;

import lombok.Data;

@Data
public class EmployerDto {
    private String id;
    private String name;
    private String url;
    private String alternateUrl;
    private LogoUrlsDto logoUrls;
    private String vacanciesUrl;
    private Boolean accreditedItEmployer;
    private Boolean trusted;
}
