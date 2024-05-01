package dev.lxqtpr.linda.vacancyimportservice.dto.hh;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Snippet {
    @JsonProperty("requirement")
    private String requirement;
    @JsonProperty("responsibility")
    private String responsibility;
}
