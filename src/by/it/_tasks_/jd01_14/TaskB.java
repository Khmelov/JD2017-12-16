package by.it._tasks_.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    static String dir(Class cl) {
        String cldir = cl.getName().replace(cl.getSimpleName(), "").replace(".", "/");
        return System.getProperty("user.dir") + "/src/" + cldir;
    }

    public static void main(String[] args) throws IOException {
        String filename = dir(TaskB.class) + "text.txt";
        File f = new File(filename);
        Pattern marks = Pattern.compile("\\.\\.\\.|[.,!:-]");
        int m = 0;
        Pattern words = Pattern.compile("[a-zа-яА-ЯёЁ]+");
        int w = 0;
        //=============================================================
        try (BufferedReader reader = new BufferedReader(new FileReader(f));
             PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskA.class) + "resultTaskB.txt"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher mm = marks.matcher(line);
                while (mm.find()) m++;
                Matcher mw = words.matcher(line);
                while (mw.find()) w++;
            }
            out2.printf("words=%s, punctuation marks=%s\n", w, m);
            System.out.printf("words=%s, punctuation marks=%s\n", w, m);

        }

    }
}
