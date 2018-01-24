package by.it.pozdeev.jd01_08;

public class Jeep extends Cars{
    private String road = "asphalt";
    private byte driveUnit =2;

    public void moveTo(String str,String r) {
        super.destination=str;
        super.moveTo();
        road=r;
        if (road.equals("asphalt")) driveUnit=2;
        else driveUnit=4;
        System.out.println("Road= "+road+" DriveUnit= "+driveUnit);
        System.out.println("-----------------------------");

    }

    @Override
    public String toString() {
        return super.toString()+"\n"+"Road= "+road+" DriveUnit= "+driveUnit+"\n-----------------------------";
    }
}
