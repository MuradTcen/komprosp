package converters;

import converters.impl.CelsiusConverter;
import converters.impl.FahrenheitConverter;
import converters.impl.KelvenConverter;

public interface Converter {
    double getConvertedValue(double value);

    static Converter getInstance(ConverterType type) {
        switch (type.getValue()) {
            case ("Fahrenheit"):
                return new FahrenheitConverter();
            case ("Kelven"):
                return new KelvenConverter();
            default:
                return new CelsiusConverter();
        }
    }
}
