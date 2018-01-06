package by.it.ikiselev.jd01_08;

public class VideoPlayer extends Pleer{




    @Override
    public boolean play(String track) {
        setCurrentTrack(track);
        boolean result=play();
        if (result)
            System.out.println("Video"+this);
        return result;
    }

    @Override
    public boolean stop() {
        return super.stop();
    }
}
