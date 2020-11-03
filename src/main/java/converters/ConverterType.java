package converters;

public enum ConverterType {
    KELVENCONVERTER("Kelven"),
    FAHRENHEITCONVERTER("Fahrenheit"),
    CELSIUSCONVERTER("Celsius");
    private String value;

    ConverterType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
