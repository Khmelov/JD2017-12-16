package by.it.kozlov.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;
    private final String path = "by/it/kozlov/jd02_05/properties";

    ResourceBundle resourceBundle;
    Locale locale;

    void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(path, locale);
    }

    String get(String key) {
        return resourceBundle.getString(key);
    }

    String getDate() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
        Date date = new Date();
        return dateFormat.format(date);
    }
}
