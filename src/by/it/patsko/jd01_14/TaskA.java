package by.it.patsko.jd01_14;

import java.io.*;

/*
Вариант А. В классе TaskA нужно выполнить следующие шаги:
 Записать в двоичный файл dataTaskA.bin 20 случайных чисел типа Integer.
 Файл должен быть в том же каталоге, что и исходный код для класса
TaskA.java.
 Затем нужно прочитать записанный файл в коллекцию ArrayList.
 Вывести в консоль прочитанные числа через пробел
 Вывести с новой строки их среднее арифметическое avg=20.123.
 Продублировать вывод в консоль в файл resultTaskA.txt
 */
class TaskA {
    public static void main(String[] args) {
        String src = System.getProperty("user.dir");
        src = src + "/src/by/it/patsko/jd01_14/";
        File file = new File(src, "dataTaskA.bin");
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(file)))) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) Math.round(Math.random() * 20));
//                dos.writeByte(i+70);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //read
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(file))); PrintWriter out2 = new PrintWriter(new FileWriter(new File(src, "resultTaskA.txt")))) {
            double sum = 0;
            int count = 0;
            while (dis.available() > 0) {
                int value = dis.readInt();
                System.out.print(value + " ");
                out2.print(value + " ");
                sum += value;
                count++;
            }
            System.out.println("\navg=" + sum / count);
            out2.println("\navg=" + sum / count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
