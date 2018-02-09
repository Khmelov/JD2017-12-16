package by.it.vshelukhin.calc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

public class Singleton {

    private static Singleton loger;

    private Singleton() {
        super();
    }

    public static Singleton getLoger() {
        Singleton temp = loger;
        if (temp == null) {
            synchronized (Singleton.class) {
                temp = loger;
                if (temp == null) {
                    loger = new Singleton();
                    temp = loger;
                }
            }
        }
        return temp;
    }

    public void writeLog(String textLog){
        StringBuilder sb = new StringBuilder();

        sb.append(new Date());
        sb.append("\t");
        sb.append(textLog);
        sb.append("\n");

        File f = new File(getPass(), "log.txt");
        try (BufferedWriter br = new BufferedWriter(new FileWriter(f, true))){
            br.write(sb.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private String getPass(){
        StringBuilder sbPath = new StringBuilder();
        sbPath.append(System.getProperty("user.dir"));
        sbPath.append(File.separator);
        sbPath.append("src");
        sbPath.append(File.separator);
        sbPath.append((new Singleton()).getClass().getName().replace((new Singleton()).getClass().getSimpleName(),"").replace(".",File.separator));
        return sbPath.toString();
    }
}
