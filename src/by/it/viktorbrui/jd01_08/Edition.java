package by.it.viktorbrui.jd01_08;

public interface Edition {
    void ProcessStart();
    void ProcessEnd();
    boolean inProcess();
    boolean endProcess();
    boolean stopProcess();
}
