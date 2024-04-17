package dev.lxqtpr.linda.vacancyimportservice.dto.hh;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Employer {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("alternate_url")
    private String alternateUrl;
    @JsonProperty("logo_urls")
    private LogoUrls logoUrls;
    @JsonProperty("vacancies_url")
    private String vacanciesUrl;
    @JsonProperty("accredited_it_employer")
    private Boolean accreditedItEmployer;
    @JsonProperty("trusted")
    private Boolean trusted;
}
