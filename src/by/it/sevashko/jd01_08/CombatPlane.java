package by.it.sevashko.jd01_08;

public class CombatPlane implements Plane {

    private boolean engineIsWorking;
    private boolean inAir = false;;
    private int currentSpeed = 0;
    private int currentFlightAltitude = 0;
    private int maxSpeed = 45;
    private int roofOfFlight = 80;

    CombatPlane(){}

    CombatPlane(int newMaxSpeed, int newRoof){
        maxSpeed = newMaxSpeed;
        roofOfFlight = newRoof;
    }

    @Override
    public void engineStart() {
        if (!engineIsWorking) {
            System.out.println("Engine launching");
            engineIsWorking = true;
            System.out.println("Engine on");
        }
    }

    @Override
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

    public void flyUp(int flightAltitude) {
        int speedOfTakeoff = 30;
        if (!engineIsWorking) engineStart();
        System.out.println("Acceleration");
        while (currentSpeed < speedOfTakeoff){
            System.out.printf("Current speed is %d\n", currentSpeed);
            currentSpeed = currentSpeed + 5;
        }
        System.out.printf("Current speed is %d\n", currentSpeed);
        System.out.println("Takeoff");
        inAir = true;
        while (currentFlightAltitude < flightAltitude){
            currentFlightAltitude = currentFlightAltitude + 10;
            System.out.printf("Flight Altitude is %d\n", currentFlightAltitude);
        }
    }

    @Override
    public void landOnBase(){
        System.out.println("Going on the runway");
        this.changeSpeed(30);
        this.changeFlightAltitude(0);
        System.out.println("Touch");
        this.changeSpeed(0);
    }

    @Override
    public void changeSpeed(int newSpeed) {
        if (newSpeed > maxSpeed) newSpeed = maxSpeed;
        if (currentSpeed < newSpeed){
            while (currentSpeed < newSpeed){
                currentSpeed = currentSpeed + 5;
                System.out.printf("Current speed is %d\n", currentSpeed);
            }
        }
        if (currentSpeed > newSpeed){
            while (currentSpeed > newSpeed){
                currentSpeed = currentSpeed - 5;
                System.out.printf("Current speed is %d\n", currentSpeed);
            }
        }
        if (currentSpeed == maxSpeed) System.out.println("Max speed!");
    }

    @Override
    public void changeFlightAltitude(int newFlightAltitude) {
        if (newFlightAltitude > roofOfFlight) newFlightAltitude = roofOfFlight;
        if (currentSpeed < newFlightAltitude){
            while (currentFlightAltitude < newFlightAltitude){
                currentFlightAltitude = currentFlightAltitude + 10;
                System.out.printf("Current Flight Altitude is %d\n", currentFlightAltitude);
            }
        }
        if (currentFlightAltitude > newFlightAltitude){
            while (currentFlightAltitude > newFlightAltitude){
                currentFlightAltitude = currentFlightAltitude - 10;
                System.out.printf("Current Flight Altitude is %d\n", currentFlightAltitude);
            }
        }
        if (currentFlightAltitude == roofOfFlight) System.out.println("Higher impossible");
    }

    void destroyTarget(String nameOfTarget){
        System.out.println("no Arms!");
    }

    @Override
    public String getParameters() {
        StringBuilder line = new StringBuilder();
        line.append("Current Flight altitude is " + currentFlightAltitude + "\n");
        line.append("Current Speed is " + currentSpeed + "\n");
        return line.toString();
    }
}
