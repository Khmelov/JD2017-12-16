package by.it.sevashko.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    ResourceBundle resourceBundle;
    Locale locale;

    ResMan() {
        Locale.setDefault(Locale.ENGLISH);
        setLocale(Locale.ENGLISH);
    }

    private final String path = "by.it.sevashko.jd02_05.resources.text";

    void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(path, locale);
    }

    String get(String key) {
        return resourceBundle.getString(key);
    }

    String getDate(){
        Date date = new Date();
        DateFormat df = DateFormat.getDateTimeInstance(0,1, locale);
        return df.format(date);
    }
}
