package by.it.patsko.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private ResourceBundle rb;
    private Locale locale;
    private final String path = "by/it/patsko/jd02_05/resource/str";
    private DateFormat dateFormat;

    private ResMan() {
        Locale.setDefault(new Locale("en", "US"));
        setLocale(Locale.getDefault());
        dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM,Locale.getDefault());
    }

    void setLocale(Locale locale) {
        this.rb = ResourceBundle.getBundle(path, locale);
        this.locale = locale;
        dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM,locale);
    }

    String get(String key) {
        return rb.getString(key);
    }
    String currentData(){
        return dateFormat.format(new Date());
    }
}
