package by.it.viktorbrui.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    ResourceBundle rb;
    Locale locale;

    private ResMan() {
        setLocale(Locale.getDefault());
    }

    private final String path = "by.it.viktorbrui.jd02_05.resources.strings";

    void setLocale(Locale locale) {
        this.locale = locale;
        rb = ResourceBundle.getBundle(path, locale);
    }

    String get(String key) {
        return rb.getString(key);
    }
}
