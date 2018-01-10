package by.it.viktorbrui.jd01_08.homeWork;

public interface Edition {
    void processStart();
    void processEnd();
    boolean inProcess(String print);
    boolean inProcess();
    boolean endProcess();
    boolean stopProcess();
}
