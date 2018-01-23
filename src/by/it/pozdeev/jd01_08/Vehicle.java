package by.it.pozdeev.jd01_08;

public interface Vehicle {
    boolean engineOn();
    boolean brake();
    boolean trip();
    void moveTo(String str,String r);
    void moveTo();
    void stop();
    int fuelLevel();
    void fuelLevel(int value);
}
