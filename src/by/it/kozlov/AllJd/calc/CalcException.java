package by.it.kozlov.calc;

import by.it.kozlov.calc.builder.*;

import java.util.LinkedList;
import java.util.Queue;

public class CalcException extends Exception {
    public static Queue<String> stringQueue = new LinkedList<>();

    public CalcException() {
    }

    public CalcException(String message) {
        super(message);
        stringQueue.add(message);
        Director director = new Director();
        BuildAbstractLog log = new FullLog();
        director.setBuildAbstractLogBuilder(log);
        director.constructLog();
//        log = new ShortLog();
//        director.setBuildAbstractLogBuilder(log);
//        director.constructLog();
    }

    public CalcException(String message, Throwable cause) {
        super(message, cause);
        stringQueue.add(message);
        Director director = new Director();
        BuildAbstractLog log = new FullLog();
        director.setBuildAbstractLogBuilder(log);
        director.constructLog();
//        log = new ShortLog();
//        director.setBuildAbstractLogBuilder(log);
//        director.constructLog();
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
