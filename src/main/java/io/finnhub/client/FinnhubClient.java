package io.finnhub.client;

import feign.Param;
import feign.RequestLine;
import io.finnhub.enums.FinnhubExchangeEnums;
import io.finnhub.enums.FinnhubResolutionEnums;
import io.finnhub.models.Candles;
import io.finnhub.models.Symbol;

import java.util.List;

public interface FinnhubClient {

    @RequestLine("GET /{exchangeType}/exchange")
    List<String> getExchanges(@Param("exchangeType") FinnhubExchangeEnums exchangeType);

    @RequestLine("GET /{exchangeType}/symbol?exchange={exchange}")
    List<Symbol> getSymbols(@Param("exchangeType") FinnhubExchangeEnums exchangeType, @Param("exchange") String exchange);

    @RequestLine("GET /{exchangeType}/candle?symbol={symbol}&resolution={resolution}&from={from}&to={to}")
    Candles getCandles(@Param("exchangeType") FinnhubExchangeEnums exchangeType,
                       @Param("symbol") String symbol,
                       @Param("resolution") FinnhubResolutionEnums resolution,
                       @Param("from") Long from,
                       @Param("to") Long to);
}
