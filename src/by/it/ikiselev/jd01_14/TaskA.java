package by.it.ikiselev.jd01_14;

import java.io.*;

public class TaskA {
    public static void main(String[] args) {
        String pass=System.getProperty("user.dir");
        pass=pass+"/src/by/it/ikiselev/jd01_14/";
        File file=new File(pass, "dataTaskA.bin");
        try {
            DataOutputStream fl= new DataOutputStream(new FileOutputStream(file));
            for (int i = 0; i < 80; i++) {
                fl.writeByte(i);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

//    try {
//        DataInputStream kis=new DataInputStream(
//                new BufferedInputStream(
//                        new FileInputStream(file)
//                ))
//    }
//        catch (IOException e) {
//        e.printStackTrace();
//    }



}
