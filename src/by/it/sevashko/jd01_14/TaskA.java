package by.it.sevashko.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        path = path + "/src/by/it/sevashko/jd01_14";
        File file = new File(path, "dataTaskA.bin");

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random()*1000));
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        double sum = 0;
        int cont = 0;
        List<Integer> list = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)
                )
        )){
            while (dis.available() > 0) {
                int value = dis.readInt();
                sum = sum + value;
                cont++;
                list.add(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file1 = new File(path, "resultTaskA.txt");
        try (PrintStream w = new PrintStream(file1)){
            for (Integer element : list){
                System.out.printf("%d ", element);
                w.printf("%d ", element);
            }
            System.out.println();
            w.println();
            System.out.printf("avg=%s", sum/cont);
            w.printf("avg=%s", sum/cont);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
