package by.it.patsko.jd01_08.example;


public class Videopleer extends Pleer {


    @Override
    public boolean play(String track) {
        setCurrentTrack(track);
        boolean result=play();
        if(result)System.out.println("Videopleer play"+this);
        return result;
    }

    @Override
    public boolean stop() {
        boolean result=super.stop();
        if(result)System.out.println("Stopped"+this);
        return result;
    }
}
