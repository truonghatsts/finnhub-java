
# finnhub-java
Finnhub Java Client is the Java client using [OpenFeign](https://github.com/OpenFeign/feign) to make call to Finnhub.io.

### Usages
It is very straightforward.
```java
String token = "your-token";
FinnhubClient client = FinnhubApiClientFactory.newInstance(token);
// Get list of Crypto exchanges
List<String> exchanges = finnhubClient.getExchanges(FinnhubExchangeEnums.CRYPTO);

// Get list of Symbols on Binance exchange
List<Symbol> symbols = finnhubClient.getSymbols(FinnhubExchangeEnums.CRYPTO, "Binance");

// Get the last 30 days OHLC of BTCUSDT on Binance exchange
ZonedDateTime to = Instant.now().atZone(ZoneOffset.UTC);
        ZonedDateTime from = to.minusDays(30);
        Candles candles = finnhubClient.getCandles(FinnhubExchangeEnums.CRYPTO, 
                "BINANCE:BTCUSDT", 
                FinnhubResolutionEnums.DAY, 
                from.toEpochSecond(), 
                to.toEpochSecond());
```

### Roadmap
Add more endpoints:
- WEBSOCKET
- STOCK FUNDAMENTALS
- STOCK ESTIMATES
- STOCK PRICE
- FOREX
- CRYPTO
- TECHNICAL ANALYSIS
- ALTERNATIVE DATA
- ECONOMIC