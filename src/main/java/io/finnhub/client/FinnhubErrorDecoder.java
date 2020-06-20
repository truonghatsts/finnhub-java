package io.finnhub.client;

import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;

import java.io.IOException;

public class FinnhubErrorDecoder implements ErrorDecoder {

    final Decoder decoder;
    final ErrorDecoder defaultDecoder = new ErrorDecoder.Default();

    FinnhubErrorDecoder(Decoder decoder) {
        this.decoder = decoder;
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            // must replace status by 200 other GSONDecoder returns null
            response = response.toBuilder().status(200).build();
            return (Exception) decoder.decode(response, FinnhubClientError.class);
        } catch (final IOException fallbackToDefault) {
            return defaultDecoder.decode(methodKey, response);
        }
    }
}
