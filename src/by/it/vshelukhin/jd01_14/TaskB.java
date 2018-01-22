package by.it.vshelukhin.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {

        StringBuilder link = new StringBuilder();
        link.append(System.getProperty("user.dir"));
        link.append("\\src\\");
        link.append(new TaskB().getClass().getName().replaceAll("\\.[A-Z][a-zA-Z]*","").replaceAll("\\.","\\\\"));
        //System.out.println(link);

        File f = new File(link.toString(),"TaskB.txt");

        StringBuilder text = new StringBuilder();
        int b;

        try(BufferedReader reader = new BufferedReader(new FileReader(new File(link.toString(),"TaskB.txt")))) {
            while ((b = reader.read()) != -1){
                text.append((char)b);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(text);

        StringBuilder result = new StringBuilder();
        int count=0;

        Pattern pat = Pattern.compile("[а-яА-ЯёЁa-zA-Z]+");
        Matcher mat = pat.matcher(text);

        while (mat.find()){
            count++;
        }
        result.append("words=");
        result.append(count);

        count = 0;
        pat = Pattern.compile("\\.\\.\\.|\\p{Punct}");
        mat = pat.matcher(text);
        while (mat.find()){
            count++;
        }

        result.append(",punctuation marks=");
        result.append(count);

        System.out.println(result);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(link.toString(),"resultTaskB.txt")))) {
            writer.write(result.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
