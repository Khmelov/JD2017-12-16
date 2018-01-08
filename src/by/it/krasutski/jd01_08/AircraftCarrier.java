package by.it.krasutski.jd01_08;

public class AircraftCarrier extends Warship {

    @Override
    public boolean moveTo(String str) {
        setDest(str);
        boolean result=super.moveTo();
        if (result)
            System.out.println(this);
        return result;
    }

    @Override
    public boolean alarm(String s) {
        setAlarm(s);
        boolean result=super.alarm();
        if (result)
            System.out.println(this);
        return result;
    }
}
