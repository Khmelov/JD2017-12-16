package by.it.sevashko.jd01_08;

public interface Plane {
    void engineStart();
    void engineShutdown();
    void flyUp();
    void landOnBase();
    void changeFlightAltitude(int flightAltitude);
    void changeSpeed(int newSpeed);
    String getParameters();
}
