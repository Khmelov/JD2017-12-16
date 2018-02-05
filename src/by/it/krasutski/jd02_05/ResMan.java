package by.it.krasutski.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    ResourceBundle resourceBundle;
    Locale locale;
    final String path = "by/it/krasutski/jd02_05/resources/strings";
    DateFormat dateFormat;

    ResMan() {
        Locale.setDefault(new Locale("en", "US"));
        setLocale(Locale.getDefault());
        dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
    }

    void setLocale(Locale locale) {
        this.resourceBundle = ResourceBundle.getBundle(path, locale);
        this.locale = locale;
        dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
    }

    String getLocale(String key) {
        return resourceBundle.getString(key);
    }

    String currentData() {
        return dateFormat.format(new Date());
    }
}