package by.it.karpeichyk.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

import static com.sun.org.apache.xerces.internal.dom.DOMMessageFormatter.setLocale;

/**
 * Created by user on 03.02.2018.
 */

public  enum ResursProperity {
    INSTANCE;
    ResourceBundle rb;
    Locale locale;
     ResursProperity(){rb=ResourceBundle.getBundle(path,Locale.getDefault());}
    private  final  String path="by.it.karpeichyk.jd02_05.resurs.msg";
    void setLocale(Locale locale){
        this.locale= locale;
        rb=ResourceBundle.getBundle(path,locale);
    }
    String get(String key){return  rb.getString(key);}
}
