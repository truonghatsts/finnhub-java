package io.finnhub.models;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Symbol {

    private String description;
    private String displaySymbol;
    private String symbol;
}
