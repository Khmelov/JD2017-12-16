package by.it.vshelukhin.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class TaskC {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        StringBuilder link = new StringBuilder();
        link.append(System.getProperty("user.dir"));
        link.append("\\src\\by\\it\\");
        //link.append(new TaskC().getClass().getName().replaceAll("\\.[A-Z][a-zA-Z]*","").replaceAll("\\.","\\\\"));

        sb.append("dir:..\n");

        printer(link.toString());

        System.out.println(sb.toString());

        link.append("\\vshelukhin\\jd01_14\\");
        File f = new File(link.toString(),"resultTaskC.txt");
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
            writer.write(sb.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }



//        File f = new File(link.toString());
//        String path = f.getPath()+"\\";
//        String[] files = f.list();
//        System.out.println(path+files[0]);

    }

    static void printer(String str){
        File f = new File(str);
        if (f.isFile()) {
            sb.append("file:");
            sb.append(f.getName());
            sb.append("\n");
            return;
        }
        sb.append("dir:");
        sb.append(f.getName());
        sb.append("\n");
        String path = f.getPath()+"\\";
        String[] files = f.list();
        for (String file : files) {
            printer(path+file);
        }
    }
}
