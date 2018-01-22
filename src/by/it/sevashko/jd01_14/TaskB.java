package by.it.sevashko.jd01_14;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static int words = 0;
    private static int punctuationMarks = 0;

    public static void main(String[] args) {
        /*Properties properties = System.getProperties();
        for (Map.Entry entry : properties.entrySet()){
            System.out.println(entry);
        }*/
        String path = System.getProperty("user.dir");
        path = path + "/src/by/it/sevashko/jd01_14";
        File fileToRead = new File(path, "text.txt");
        File fileToWrite = new File(path, "resultTaskB.txt");
        try (BufferedReader fr = new BufferedReader(
                new FileReader(fileToRead));
             PrintStream fw = new PrintStream(fileToWrite)
        ){
            Pattern pattern = Pattern.compile("([А-Яа-яЁё]+)|([!?,.-:]+)");
            while (fr.ready()) {
                String line = fr.readLine();
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()){
                    System.out.println(matcher.group());
//                    if (matcher.group().matches("([А-Яа-яЁё]+)")){
                    if (matcher.group(1) != null){
                        words++;
                    } else {
                        punctuationMarks++;
                    }
                }
            }
            System.out.printf("words=%d, punctuation marks=%d", words, punctuationMarks);
            fw.printf("words=%d, punctuation marks=%d", words, punctuationMarks);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
