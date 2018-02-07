package by.it.vshelukhin.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResoursManager {
    private static ResoursManager resMan;

    Locale locale;

    ResourceBundle rb;

    private ResoursManager(){
        super();
        Locale.setDefault(Locale.US);
        locale = Locale.getDefault();
        rb = ResourceBundle.getBundle("by\\it\\vshelukhin\\jd02_05\\text",locale);
    }

    public static ResoursManager getResMan() {
        if (resMan == null) {
            resMan = new ResoursManager();
        }
        return resMan;
    }

    public void setLocale(Locale loc){
        locale = loc;
        rb = ResourceBundle.getBundle("by\\it\\vshelukhin\\jd02_05\\text",locale);
    }

    public String getRes (String key){
        return rb.getString(key);
    }
}
