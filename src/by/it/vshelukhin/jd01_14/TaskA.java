package by.it.vshelukhin.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        //System.out.println(new TaskA().getClass().getName().replaceAll("\\.","/"));
        StringBuilder link = new StringBuilder();
        link.append(System.getProperty("user.dir"));
        link.append("\\src\\");
        link.append(new TaskA().getClass().getName().replaceAll("\\.[A-Z][a-zA-Z]*","").replaceAll("\\.","\\\\"));
        //sb.append("/dataTaskA.bin");
        System.out.println(link);
        File f = new File(link.toString(), "dataTaskA.bin");
       // System.out.println(new TaskA().getClass().getName().replaceAll("\\.[A-Z][a-zA-Z]*",""));
        try (DataOutputStream wr = new DataOutputStream(new FileOutputStream(f))){
            for (int i = 0; i < 20; i++) {
                wr.writeInt((int)(random()*100));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        List<Integer> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        int sum = 0;
        try(DataInputStream rd = new DataInputStream(new BufferedInputStream(new FileInputStream(f)));
            Writer wr = new BufferedWriter(new FileWriter(new File(link.toString(), "resultTaskA.txt")))
        ) {
            while (rd.available()!=0) {
                int el = rd.readInt();
                sum = sum + el;
                list.add(el);
                result.append(el+" ");
            }
            result.append("\navg=");
            result.append((double)sum/list.size());
            wr.append(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(result.toString());
    }
}
