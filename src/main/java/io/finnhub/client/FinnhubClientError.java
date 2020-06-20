package io.finnhub.client;

public class FinnhubClientError extends RuntimeException {
    private String message; // parsed from json

    @Override
    public String getMessage() {
        return message;
    }
}