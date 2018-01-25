package by.it.pozdeev.jd01_15;

import by.it.pozdeev.jd01_10.Param;

import java.io.*;

@Param(a = 4, b = 6)
public class TaskB {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/" + "src" + "/" +
                TaskB.class.getName().replace(TaskB.class.getSimpleName(), "").replaceAll("\\.", "/");
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path, "TaskB.java")))) {
            StringBuilder sb=new StringBuilder();
            int sh;
            char symbol;
         //   while ((symbol=(char)reader.read())!=null){
       //         symbol=(char)sh;

   //         }
    //        sb.append(reader.read());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Комментарий

        //Комментарий

        /*
           Комментарий
         */

        /*
            Комментарий
         */
    }
}
