package dev.lxqtpr.linda.vacancyimportservice.dto;

import lombok.Data;

@Data
public class Employer {
    private String id;
    private String name;
    private String url;
    private String alternateUrl;
    private LogoUrls logoUrls;
    private String vacanciesUrl;
    private Boolean accreditedItEmployer;
    private Boolean trusted;
}
