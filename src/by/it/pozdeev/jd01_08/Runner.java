package by.it.pozdeev.jd01_08;

public class Runner {
    public static void main(String[] args) {
        Vehicle bmw=new Jeep();
        System.out.println(bmw);
        bmw.moveTo("Moscow","asphalt");

        System.out.println(bmw);
        bmw.fuelLevel(5);
        System.out.println(bmw);
        bmw.trip();
    }



}
