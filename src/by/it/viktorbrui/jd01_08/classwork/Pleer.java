package by.it.viktorbrui.jd01_08.classwork;

abstract class Pleer implements by.it.viktorbrui.jd01_08.classwork.Multimedia {

    private boolean powerOn;
    private boolean playState;
    private boolean pauseState;
    private String currentTrack;


    public void setCurrentTrack(String currentTrack) {
        this.currentTrack = currentTrack;
    }

    public Pleer(String currentTrack) {
        powerOn=true;
        playState=false;
        pauseState=false;
        this.currentTrack = currentTrack;
    }

    public Pleer() {
        powerOn=false;
        playState=false;
        pauseState=false;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("--------------------------\n");
        sb.append(powerOn?"Power on\n":"Power off\n");
        sb.append(playState?"Played "+currentTrack+"\n":"Play off\n");
        sb.append(pauseState?"Paused on\n":"");
        sb.append("--------------------------\n");
        return sb.toString();
    }

    @Override
    public void powerOn() {
        powerOn=true;
    }

    @Override
    public void powerOff() {
        powerOn=false;
    }

    @Override
    public boolean play() {
        if (!playState || pauseState) {
            playState=true;
            pauseState=false;
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean stop() {
        if (playState){
            playState=false;
            return true;
        }
        return false;
    }

    @Override
    public boolean pause() {
        pauseState=!pauseState;
        return pauseState;
    }



}
