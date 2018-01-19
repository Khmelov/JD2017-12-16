package by.it.vshelukhin.jd01_13;

import jdk.jfr.StackTrace;

import java.io.Serializable;
import java.util.HashMap;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {

        try {

            if (random() > 0.5) new HashMap<Integer, Integer>(null);
            else Integer.parseInt("YO!");
        }
        catch (NumberFormatException | NullPointerException e) {
            System.out.println("name: "+e.getClass().getName());
            for (StackTraceElement stt : e.getStackTrace()) {
                if (stt.getClassName().equals(TaskA.class.getName())) System.out.println("class: "+stt.getClassName()+"\nline: "+stt.getLineNumber());
            }
        }
    }
}
