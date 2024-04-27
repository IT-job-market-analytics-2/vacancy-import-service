package dev.lxqtpr.linda.vacancyimportservice.dto.hh;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Salary {
    @JsonProperty("from")
    private Integer from;
    @JsonProperty("to")
    private Integer to;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("gross")
    private Boolean gross;
}
