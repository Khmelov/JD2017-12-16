package by.it.sendetskaya.jd01_14;

import java.io.*;
import java.util.Scanner;


//Вариант B. В классе TaskB нужно выполнить следующие шаги:
// В фа ле с текстом TaskB.txt нужно подсчитать общее количество
// знаков препинания и слов
// Вывести результат на консоль в виде одно  строки:
//words=123, punctuation marks=15
// Продублировать вывод в консоль в фа л resultTaskB.txt
public class TaskB {
    public static void main(String[] args) {
        String line;
        int countWords=0, countDelimiter=0;

        String path=System.getProperty("user.dir");
        path=path+"/src/by/it/sendetskaya/jd01_14/";
        File file=new File(path,"TaskB.txt");
        File file1=new File(path,"text.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file1));
             FileWriter writer = new FileWriter(file,false)) {
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    writer.write(line);
                    writer.write("\n");
                }
            }
         catch (IOException e) {
            e.printStackTrace();
        }

        //reading

        try (PrintWriter print=new PrintWriter(new FileWriter
                     (new File(path,"resultTaskB.txt")))) {
            Scanner scan=new Scanner(file);

            scan.useDelimiter("[A-Za-zА-Яа-яЁё]+");
                while((scan.hasNext()))
                {
                    if(scan.hasNext()&&scan.next()!=null)
                        countWords++;
                }

            scan.close();

                scan=new Scanner(file);
                scan.useDelimiter("[-,?!]|[.]+");

            while((scan.hasNext()))
            {
                if(scan.hasNext()&&scan.next()!=null)
                    countDelimiter++;
            }
            scan.close();

            System.out.print("\nwords="+countWords);
            print.print("\nwords="+countWords);
            System.out.print(", punctuation marks="+countDelimiter);
            print.print(", punctuation marks="+countDelimiter);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
