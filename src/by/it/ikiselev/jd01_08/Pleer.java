package by.it.ikiselev.jd01_08;

public abstract class Pleer implements Multimedia{
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
        sb.append(powerOn?"Power is on\n":"Power off");
        sb.append(playState?"Played "+currentTrack+"\n":"Play off");
        sb.append(pauseState?"Paused on\n":"Power off");
        sb.append(powerOn?"Power is on\n":"");
        return super.toString();
    }

    @Override
    public void powerOn() {
        powerOn=true;
    }

    @Override
    public void powerOf() {
        powerOn=false;
    }

    @Override
    public boolean play() {
        if (!playState||pauseState){
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
        pauseState=!playState;
        return pauseState;
    }
}
