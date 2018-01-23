package by.it.pozdeev.jd01_08;

public abstract class Cars implements Vehicle {
    private boolean engineOn = false;
    private boolean brake = true;
    private boolean trip = false;
    public String destination = "Car is not on trip";
    private int fuelLevel;

    @Override
    public boolean engineOn() {
        System.out.println("EngineOn= " + engineOn);
        return engineOn;
    }

    public boolean brake() {
        System.out.println("Brake= " + brake);
        return brake;
    }

    public void setDest(String dest) {
        destination = dest;
    }

    public boolean trip() {
        System.out.println("Trip= " + destination);
        return trip;
    }


    @Override
    public void moveTo() {
        engineOn = true;
        brake = false;
        trip=true;
    }

    public void stop() {
        engineOn = false;
        brake = true;
    }

    public void tripComplete() {
        trip = false;
        destination = "Car is not on the trip";
    }

    public int fuelLevel() {
        return fuelLevel;
    }

    public void fuelLevel(int l) {
        fuelLevel = fuelLevel + l;
    }

    ;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(engineOn ? "Engine is on\n" : "Engine is off\n");
        sb.append(brake ? "Brake is use\n" : "Brake is not use\n");
        sb.append(trip ? "Car is on trip: "+destination+"\n" : "Car is not on trip\n");
        sb.append("Fuel level is:" + fuelLevel+"\n");
        sb.append("-----------------------------");
        return sb.toString();
    }


}