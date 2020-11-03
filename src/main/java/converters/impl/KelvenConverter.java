package converters.impl;


import converters.Converter;

public class KelvenConverter implements Converter {
    @Override
    public double getConvertedValue(double value) {
        return value + 273.15;
    }
}
