package by.it._tasks_.jd01_14;

import java.io.*;

public class TaskA {

    static String dir(Class cl){
        String cldir=cl.getName().replace(cl.getSimpleName(),"").replace(".","/");
        return System.getProperty("user.dir")+"/src/"+cldir;
    }

    public static void main(String[] args) throws IOException {
        String filename = dir(TaskA.class) + "dataTaskA.bin";
        File f = new File(filename);
        //=============================================================
        //пример записи значений типа int в двоичный файл
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(f));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 20 + 10));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файла нет: " + filename);
        } finally {
            if (dos != null) {
                dos.close();
            }
        }
        //=============================================================
        //пример чтения из файла

        try (DataInputStream inp = new DataInputStream
                (new BufferedInputStream
                        (new FileInputStream(filename))
                );
             PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskA.class)+"resultTaskA.txt"))
        ) {
            double sum = 0;
            double count = 0;
            while (inp.available() > 0) {
                int i = inp.readInt();
                out2.print(i + " ");
                System.out.print(i + " ");
                sum = sum + i;
                count++;
            }
            System.out.println("\navg=" + sum / count);
            out2.println("\navg=" + sum / count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
