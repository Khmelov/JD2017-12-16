package by.it.patsko.jd01_08;

abstract class Pleer implements Multimedia {
    private boolean powerOn;
    private boolean playState;
    private boolean pauseState;

    public String getCurrentTrack() {
        return currentTrek;
    }

    public void setCurrentTrack(String currentTrek) {
        this.currentTrek = currentTrek;
    }

    private String currentTrek;

    public Pleer() {
        powerOn = false;
        playState = false;
        pauseState = false;
        this.currentTrek = null;
    }

    public Pleer(String currentTrek) {
        powerOn = true;
        playState = false;
        pauseState = false;
        this.currentTrek = currentTrek;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((powerOn) ? "Power on\n" : "Power off");
        sb.append((playState) ? "Played\n" : "Play off");
        sb.append((pauseState) ? "Paused\n" : "Power is off");
//        sb.append((powerOn)?"Power is on\n":"Power is off");

        return sb.toString();
    }

    @Override
    public boolean stop() {
        if(playState){
            playState=false;
            return true;
        }
        return false;
    }

    @Override
    public void powerOn() {
        powerOn = true;
    }

    @Override
    public void powerOff() {
        powerOn = false;
    }

    @Override
    public void shotDown() {

    }

    @Override
    public boolean pause() {
        pauseState=!pauseState;
        return pauseState;
    }

    @Override
    public boolean play() {
        if (!playState || pauseState) {
            playState = true;
            pauseState = false;
            return true;
        } else return false;
    }
}
