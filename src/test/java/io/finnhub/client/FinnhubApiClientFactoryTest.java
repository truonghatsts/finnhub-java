package io.finnhub.client;

import io.finnhub.enums.FinnhubExchangeEnums;
import io.finnhub.enums.FinnhubResolutionEnums;
import io.finnhub.models.Candles;
import io.finnhub.models.Symbol;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

public class FinnhubApiClientFactoryTest {

    private String token = "your-token";
    private FinnhubClient finnhubClient;

    @Before
    public void setUp() throws Exception {
        finnhubClient = FinnhubApiClientFactory.newInstance(token);
    }

    @Test
    public void getExchanges() {

        List<String> exchanges = finnhubClient.getExchanges(FinnhubExchangeEnums.CRYPTO);
    }

    @Test
    public void getSymbols() {

        List<Symbol> symbols = finnhubClient.getSymbols(FinnhubExchangeEnums.CRYPTO, "Binance");
    }

    @Test
    public void getCandles() {
        ZonedDateTime to = Instant.now().atZone(ZoneOffset.UTC);
        ZonedDateTime from = to.minusDays(30);
        Candles candles = finnhubClient.getCandles(FinnhubExchangeEnums.CRYPTO,
                "BINANCE:BTCUSDT",
                FinnhubResolutionEnums.DAY,
                from.toEpochSecond(),
                to.toEpochSecond());
    }
}