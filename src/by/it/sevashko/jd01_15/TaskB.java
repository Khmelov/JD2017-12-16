package by.it.sevashko.jd01_15;

import java.io.*;

public class TaskB {

    private static StringBuilder text = new StringBuilder();
/*sdfsdf
fsdfsdfsdf
sdfsdff
 */

    public static void main(String[] args) {
        String src = System.getProperty("user.dir");                //Корень проекта
        String pathIn = "src/by/it/sevashko/jd01_15/TaskB.java";
        String pathOut = "src/by/it/sevashko/jd01_15/TaskB.txt";
        File fileIn = new File(src, pathIn);                        //Файл для чтения
        File fileOut = new File(src, pathOut);                      //sfsf sfsdgsgd/*
        readFile(fileIn);
        writeInFile(fileOut);

    }

    /*aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
     */
    private static void readFile(File file){
        try (BufferedReader br = new BufferedReader(
                new FileReader(file)
        )){
            ReadState state = ReadState.OrdinaryText;
            while (br.ready()){
                state = state.getState(br);
                char oneChar = (char) br.read();
                if (state == ReadState.OrdinaryText) {
                    text.append(oneChar);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param file
     */
    private static void writeInFile(File file){
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(file)
        )){
            pw.print(text);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

