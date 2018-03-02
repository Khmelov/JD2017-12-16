package by.it.kozlov.jd02_10.converter;

public class ConverterFactory<T> {
    public static AbstractConverter convert(EConverter eConverter) {
        switch (eConverter) {
            case TO_XML:
                return new POJO_to_XML();
            case TO_JSON:
                return new POJO_to_JSON();
        }
        return null;
    }
}
