package io.finnhub.enums;

public enum FinnhubResolutionEnums {
    ONE_MINUTE("1"),
    FIVE_MINUTES("5"),
    QUARTER("15"),
    HALF_HOUR("30"),
    HOUR("60"),
    DAY("D"),
    WEEK("W"),
    MONTH("M");

    private final String value;

    FinnhubResolutionEnums(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
