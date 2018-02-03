package by.it.patsko.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    ResourceBundle rb;
    Locale locale;
    private final String path="by/it/patsko/jd02_05/resourse/str";
    private ResMan() {
        setLocale(Locale.getDefault());
    }
    void setLocale(Locale locale){
        this.rb = ResourceBundle.getBundle(path,locale);
        this.locale = locale;
    }
    String get(String key){
        return rb.getString(key);
    }
}
