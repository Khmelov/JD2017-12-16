package by.it.viktorbrui.jd01_08.classwork;


public class VideoPleer extends Pleer {

    @Override
    public boolean play(String track) {
        setCurrentTrack(track);
        boolean result=play();
        if (result)
            System.out.println("Videopleer Play:\n"+this);
        return result;
    }

    @Override
    public boolean stop() {
        boolean result=super.stop();
        if (result)
            System.out.println("Videopleer Stop:\n"+this);
        return result;
    }
}
