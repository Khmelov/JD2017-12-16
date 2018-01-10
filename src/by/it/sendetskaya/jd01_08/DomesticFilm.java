package by.it.sendetskaya.jd01_08;

public abstract class DomesticFilm implements Film {

    private boolean powerOn;
    private boolean playState;
    private boolean pauseState;
    private boolean downloadFilm;
    private boolean watchOnlineFilm;
    private boolean playWithSubtitres;
    private String currentNameFilm;
    private int yearFilm;
    private int ratingFilm;
    private int quality;

    public int getYearFilm() {
        return yearFilm;
    }

    public void setYearFilm(int yearFilm) {
        this.yearFilm = yearFilm;
    }

    public int getRatingFilm() {
        return ratingFilm;
    }

    public void setRatingFilm(int ratingFilm) {
        this.ratingFilm = ratingFilm;
    }

    public int getQuality() {
        return quality;
    }

    @Override
    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getCurrentNameFilm() {
        return currentNameFilm;
    }

    public void setCurrentNameFilm(String currentNameFilm) {
        this.currentNameFilm = currentNameFilm;
    }

    public DomesticFilm(String currentNameFilm) {
        powerOn=true;
        playState=false;
        pauseState=false;
        playWithSubtitres=false;
        this.currentNameFilm = currentNameFilm;
    }

    public DomesticFilm() {
        powerOn=false;
        playState=false;
        pauseState=false;
        playWithSubtitres=false;
    }

    @Override
    public void chooseYear(int year) {
        this.yearFilm=year;
    }

    @Override
    public void ratingFilm(int rating) {
        this.ratingFilm=rating;
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append(powerOn?"Power on\n": "Power off\n");
        sb.append(playState?"Played "+ currentNameFilm +"\n":"Play off\n");
        sb.append(pauseState?"Pause\n":"Play on\n");
        sb.append(downloadFilm?"Downloaded " +currentNameFilm+"\n":"Error download\n");
        sb.append((yearFilm!=0)?"Year of film "+yearFilm+"\n":"Year of film unknown\n");
        sb.append(watchOnlineFilm?"Watch online "+currentNameFilm+"\n":"You haven't chosen any film yet!\n");
        sb.append((ratingFilm!=0)?"Rating of film "+ratingFilm+"\n":"Rating of film unknown\n");
        sb.append((quality!=0)?"Quality of film "+quality+"\n":"Quality of film can't choose\n");
        sb.append(playWithSubtitres?"Watch with subtitles \n":"Watch without subtitles\n");
        sb.append("------------------------------------------------");
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
    public void watchOnline(String nameFilm) {
        watchOnlineFilm=true;
        this.currentNameFilm=nameFilm;
    }

    @Override
    public void download(String nameFilm) {
        downloadFilm=true;
        this.currentNameFilm=nameFilm;
    }

    @Override
    public boolean playWithSubtitres() {
        return playWithSubtitres=true;
    }

    @Override
    public boolean play() {
        if(!playState||pauseState)
        {
            playState=true;
            pauseState=false;
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean play(String track) {
        if(!playState||pauseState)
        {
            playState=true;
            pauseState=false;
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean stop() {
        if(playState) {
            playState = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean pause() {
        playState=!playState;
        return pauseState;
    }
}
