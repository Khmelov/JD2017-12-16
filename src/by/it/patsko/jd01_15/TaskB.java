package by.it.patsko.jd01_15;
//Класс TaskB
//В программе создайте хотя бы 5 разных комментариев: 2 однострочных, 2 многострочныхи 1 JavaDoc
/*
Программа должна прочитать свой собственный текст в переменную типа StringBuilder.
Читая программу необходимо удалить все возможные виды комментариев, не трогая остальное.
 */
/*
Результат вывести на консоль и в файл с тем же местоположением и именем, но с расширением txt,а не java.
Считайте, что комментарии внутри строки невозможны (s=“//так не бывает”)
 */

import java.io.*;

/**
 * //и внутри комментария тоже /** bla… /*так не бывает*bla… //и так тоже bla…  Регулярные выражения использовать нельзя
 */
public class TaskB {
    private static Comments[] comments = Comments.values();

    public static void main(String[] args) {
        StringBuilder sb = readFile(new File(TaskA.getPath(), "TaskB.java"));
        sb = readString(sb.toString());
        System.out.println(sb);
        writeFileWithoutComments(new File(TaskA.getPath(), "TaskB.txt"), sb);
    }

    private static StringBuilder readFile(File file) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new FileReader(file)
        )) {
            String str;
            while ((str = br.readLine()) != null) {
                result.append(str).append(System.getProperty("line.separator"));
                /*Можно еще:    System.lineSeparator()       String.format("%n", "")       result.append("\n");*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static StringBuilder readString(String str) {
        StringBuilder result = new StringBuilder();
        try (StringReader stringReader = new StringReader(str)) {
            StringBuilder sb = new StringBuilder();
            int i = 1;
            while (i < str.length()) {
                sb.append(str.substring(i - 1, i + 1));
                for (int j = 0; j < comments.length; j++) {
                    if (sb.toString().equals(comments[j].getStart()))
                        i += stringReader.skip(comments[j].numCharToSkip(str.substring(i + 1)));
                }
                result.append((char) stringReader.read());
                i++;
                sb.setLength(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void writeFileWithoutComments(File file, StringBuilder sb) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(file)
        )) {
            while (sb.length() > 0) {
                bufferedWriter.write(sb.substring(0, sb.length() < 10 ? sb.length() : 10));
                sb.delete(0, sb.length() < 10 ? sb.length() : 10);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}