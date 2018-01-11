package by.it.sevashko.jd01_08;

public class CombatPlane implements Plane {

    private boolean engineIsWorking;
    private int speedOfTakeoff = 30;
    private int currentSpeed = 0;
    private int currentFlightAltitude = 0;
    int maxSpeed = 45;

    public void engineStart() {
        if (!engineIsWorking) {
            System.out.println("Engine launching");
            engineIsWorking = true;
            System.out.println("Engine on");
        }
    }

    public void engineShutdown() {
        if (engineIsWorking) {
            System.out.println("Engine shutting down");
            engineIsWorking = false;
            System.out.println("Engine off");
        }
    }

    @Override
    public void flyUp() {
        flyUp(20);
    }

    //@Overload
    public void flyUp(int flightAltitude) {
        if (!engineIsWorking) engineStart();
        System.out.println("Acceleration");
        while (currentSpeed < speedOfTakeoff){
            System.out.printf("Current speed is %d\n", currentSpeed);
            currentSpeed = currentSpeed + 5;
        }
        System.out.println("Takeoff");
        while (currentFlightAltitude < flightAltitude){
            currentFlightAltitude = currentFlightAltitude + 10;
            System.out.printf("Flight Altitude is %d\n", currentFlightAltitude);
        }
    }

    public void land(){
        System.out.println('l');
    }


}
