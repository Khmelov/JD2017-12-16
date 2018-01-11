package by.it.sevashko.jd01_08;

public class Launcher {

    public static void main(String[] args) {
        CombatPlane plane1 = new Fighter();
        //plane1.engineStart();
        //plane1.engineShutdown();
        plane1.flyUp(40);
        plane1.land();
    }
}
