package by.it.krasutski.jd01_08;

public interface Ship {
    void engineOn();
    void engineOff();
    boolean moveTo(String str);
    boolean moveTo();
    boolean anchor();
    boolean inPort();
    boolean horn();
    boolean alarm(String s);
    boolean alarm();
    boolean alarmOff();

}
