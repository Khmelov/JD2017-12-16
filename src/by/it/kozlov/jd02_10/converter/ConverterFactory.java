package by.it.kozlov.jd02_10.converter;

public class ConverterFactory<T> {
    public static AbstractConverter convert(int method) {
        AbstractConverter abstractConverter;
        switch (method) {
            case 1:
                return new POJO_to_XML();
            case 2:
                return new POJO_to_JSON();
        }
        return null;
    }
}
