package io.finnhub.enums;

public enum FinnhubExchangeEnums {

    STOCK("stock"),
    CRYPTO("crypto"),
    FOREX("forex");

    private final String value;

    FinnhubExchangeEnums(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
