package io.finnhub.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Candles {

    @JsonProperty("c")
    private List<Double> closes;

    @JsonProperty("h")
    private List<Double> highs;

    @JsonProperty("l")
    private List<Double> lows;

    @JsonProperty("o")
    private List<Double> opens;

    @JsonProperty("s")
    private String status;

    @JsonProperty("t")
    private List<Long> dates;

    @JsonProperty("v")
    private List<Long> volumes;
}
