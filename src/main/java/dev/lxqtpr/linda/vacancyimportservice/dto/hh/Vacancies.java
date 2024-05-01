package dev.lxqtpr.linda.vacancyimportservice.dto.hh;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Vacancies {
    @JsonProperty("items")
    private List<Vacancy> vacancies;
    @JsonProperty("found")
    private Integer found;
    @JsonProperty("pages")
    private Integer pages;
    @JsonProperty("per_page")
    private Integer perPage;
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("clusters")
    private Object clusters;
    @JsonProperty("arguments")
    private Object arguments;
    @JsonProperty("alternate_url")
    private String alternateUrl;
}
