package converters;

import converters.impl.CelsiusConverter;
import converters.impl.FahrenheitConverter;
import converters.impl.KelvenConverter;

import static converters.ConverterType.*;

public class Main {
    public static void main(String[] args) {
        double temperature = 25;

        System.out.println(new CelsiusConverter().getConvertedValue(temperature));
        System.out.println(new FahrenheitConverter().getConvertedValue(temperature));
        System.out.println(new KelvenConverter().getConvertedValue(temperature));

        System.out.println(Converter.getInstance(KELVENCONVERTER).getConvertedValue(temperature));
        System.out.println(Converter.getInstance(FAHRENHEITCONVERTER).getConvertedValue(temperature));
        System.out.println(Converter.getInstance(CELSIUSCONVERTER).getConvertedValue(temperature));
    }
}
