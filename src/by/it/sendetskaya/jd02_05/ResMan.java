package by.it.sendetskaya.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    ResourceBundle rb;
    Locale locale;

    private ResMan()
    {
        rb=ResourceBundle.getBundle(path,Locale.getDefault());
    }

    private final  String path="by.it.sendetskaya.jd02_05.recources.strings";

    void setLocale(Locale locale)
    {
        this.locale=locale;
        rb=ResourceBundle.getBundle(path,locale);

    }

    String getString(String key)
    {
        return rb.getString(key);
    }

}
