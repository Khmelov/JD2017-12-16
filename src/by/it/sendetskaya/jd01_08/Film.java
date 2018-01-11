package by.it.sendetskaya.jd01_08;

public interface Film {

    //включить
    void powerOn();
    //выключить
    void powerOff();

    //добавить фильм
    String[] addFilm(String nameFilm);

    //скачать
    void download(String nameFilm);

    //выбрать год
    void chooseYear(int year);
    //смотреть онлайн
    void watchOnline(String nameFilm);


    //фильтр
    void  sort();

    //установить качество просмотра
    void setQuality(int quality);

    //рейтинг фильма
    void ratingFilm(int rating);

    //с субтитрами или без
    boolean playWithSubtitres();
    boolean play();
    boolean play(String nameFilm);
    boolean stop();
    boolean pause();
}
