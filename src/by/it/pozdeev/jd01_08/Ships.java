package by.it.pozdeev.jd01_08;

public interface Ships {
    boolean powerOn();
    boolean anchor();
    String destination(String str);
    boolean port();
    boolean moveTo();
    int fuelLevel();
    void addFuelLevel(int fuel);


}
