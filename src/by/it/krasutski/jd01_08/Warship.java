package by.it.krasutski.jd01_08;

public abstract class Warship implements Ship {
    private boolean engineOn;
    private boolean anchorState;
    private boolean portState;
    private boolean alarmState;
    private boolean moveTo;

    public void setAlarm(String alarm){
        this.alarm=alarm;
    }

    public void setDest(String dest){
        this.dest=dest;
    }

    private String alarm;
    private String dest;

    public Warship(String dest,String alarm){
        engineOn=true;
        anchorState=false;
        portState=false;
        alarmState=false;
        moveTo=false;
        this.dest=dest;
        this.alarm=alarm;
    }

    public Warship(){
        engineOn=false;
        anchorState=false;
        portState=true;
        alarmState=false;
        moveTo=false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(engineOn ? "Engine is on\n" : "Engine is off\n");
        sb.append(anchorState ? "Anchor in use\n" : "Anchor not in use\n");
        sb.append(portState ? "Ship in port\n" : "Ship moved out of port\n");
        sb.append(alarmState ? "Alarm: "+alarm+"\n":"Everything fine\n");
        sb.append(moveTo ? "Moving to: "+dest+"\n":"Cant move\n");
        sb.append("-------------------------------------\n");
        return sb.toString();
    }

    @Override
    public void engineOn() {
        engineOn=true;
    }

    @Override
    public void engineOff() {
        engineOn=false;
    }


    @Override
    public boolean anchor() {
        if (!anchorState){
            anchorState=true;
            moveTo=false;
            return true;
        } else
        return false;
    }

    @Override
    public boolean inPort() {
        portState=true;
        moveTo=false;
        anchorState=false;
        return true;
    }

    @Override
    public boolean horn() {
        System.out.println("Horn used");
        return true;
    }


    @Override
    public boolean moveTo() {
        if (anchorState==false && engineOn==true){
            moveTo=true;
            portState=false;
            return true;
        }else
        return false;
    }

    @Override
    public boolean alarm() {
        alarmState=true;
        return true;
    }

    @Override
    public boolean alarmOff() {
        alarmState=false;
        return true;
    }
}
