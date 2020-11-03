package converters.impl;

import converters.Converter;

public class FahrenheitConverter implements Converter {
    @Override
    public double getConvertedValue(double value) {
        return 1.8 * value + 32;
    }
}
