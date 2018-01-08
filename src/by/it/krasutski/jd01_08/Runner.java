package by.it.krasutski.jd01_08;

public class Runner {
    public static void main(String[] args) {
        Ship warship = new AircraftCarrier();
        System.out.println(warship);
        warship.engineOn();
        System.out.println(warship);
        warship.moveTo("Other base");
        warship.anchor();
        System.out.println(warship);
        warship.inPort();
        warship.horn();
        System.out.println(warship);
        warship.alarm("Code red");
        warship.alarmOff();
        System.out.println(warship);
        warship.engineOff();
        System.out.println(warship);
    }
}
