package io.finnhub.client;

import feign.Feign;
import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class FinnhubApiClientFactory {

    public static FinnhubClient newInstance(String token) {
        final Decoder decoder = new JacksonDecoder();
        final Encoder encoder = new JacksonEncoder();
        return Feign.builder()
                .encoder(encoder)
                .decoder(decoder)
                .errorDecoder(new FinnhubErrorDecoder(decoder))
                .logger(new Logger.ErrorLogger())
                .logLevel(Logger.Level.BASIC)
                .requestInterceptor(template -> {
                    template.query("token", token);
                })
                .target(FinnhubClient.class, "https://finnhub.io/api/v1/");
    }
}
