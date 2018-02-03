package by.it.akhmelev.jd02_05.classwork;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    ResourceBundle rb;
    Locale locale;

    private ResMan() {
        setLocale(Locale.getDefault());
    }

    private final String path = "by.it.akhmelev.jd02_05.classwork.resources.strings";

    void setLocale(Locale locale) {
        this.locale = locale;
        rb = ResourceBundle.getBundle(path, locale);
    }

    String get(String key) {
        return rb.getString(key);
    }
}
