package by.it._tasks_.jd01_15;
import java.io.*;
import java.util.Random;
import java.util.regex.Pattern;
/**
 * Hello B  */
public class TaskB {
    private static String dir(Class cl) {
        return System.getProperty("user.dir") + "/src/" + cl.getName().replace(cl.getSimpleName(), "").replace(".", "/");
    }
    /* много1*/
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(); //create builder
        try (
                BufferedReader reader = new BufferedReader(
                        new FileReader(dir(TaskB.class) + "TaskB.java")
                )
        ) {
            String line;
            while ((line = reader.readLine()) != null)
                sb.append(line).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = sb.toString();
        s = s.replaceAll("(?s)/\\*.*?\\*/", "");
        s = s.replaceAll("[/][/][^\n]*", "");
        System.out.println(s);

        try (BufferedWriter br = new BufferedWriter(new FileWriter(dir(TaskB.class) + "TaskB.txt"))) {
            br.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /*  много2 */
    /*  много3
    * */


}

//конец