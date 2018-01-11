package by.it.sendetskaya.jd01_08;

public class Runner {
    public static void main(String[] args) {
        Film filmCom=new Comedy();
        Film filmDom=new DomesticFilm() {
            @Override
            public String[] addFilm(String nameFilm) {
                return new String[0];
            }

            @Override
            public void sort() {

            }
        };

        filmDom.powerOn();

        filmCom.addFilm("Старики-разбойники, Кавказская пленница");
        printFilm (filmCom);

        filmCom.sort();
        printFilm (filmCom);

        filmDom.pause();
        printFilm(filmDom);

        filmDom.play();

        filmDom.stop();

        filmDom.powerOff();
        filmDom.download("Девчата");
        filmDom.chooseYear(2013);

        filmDom.play("Бриллиантовая рука");
        filmDom.watchOnline("Бриллиантовая рука");
        filmDom.setQuality(720);
        filmDom.ratingFilm(5);
        filmDom.playWithSubtitres();
        printFilm (filmDom);
    }

    static void printFilm(Film film)
    {
        System.out.println(film);
    }

}
