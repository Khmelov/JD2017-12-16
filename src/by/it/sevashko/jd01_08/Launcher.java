package by.it.sevashko.jd01_08;

public class Launcher {

    public static void main(String[] args) {
        CombatPlane plane1 = new Fighter();
        plane1.flyUp();
        plane1.changeSpeed(65);
        plane1.changeFlightAltitude(128);
        System.out.println();
        System.out.println(plane1.getParameters());
        plane1.destroyTarget("Enemy bomber");
        plane1.destroyTarget("Enemy bomber");
        plane1.destroyTarget("Enemy bomber");
        plane1.landOnBase();
        plane1.engineShutdown();
    }
}
