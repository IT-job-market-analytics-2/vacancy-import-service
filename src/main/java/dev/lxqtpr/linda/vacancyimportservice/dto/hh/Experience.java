package dev.lxqtpr.linda.vacancyimportservice.dto.hh;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Experience {
    @JsonProperty("original")
    private String original;
    @JsonProperty("90")
    private String _90;
    @JsonProperty("240")
    private String _240;
}
