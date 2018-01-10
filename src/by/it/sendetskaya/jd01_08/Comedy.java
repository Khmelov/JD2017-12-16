package by.it.sendetskaya.jd01_08;

import java.util.Arrays;


public class Comedy extends DomesticFilm {
    int ratingFilm;
    String [] nameFilm;
    int count=0;

    @Override
    public boolean play(String track) {
        setCurrentNameFilm(track);
        boolean result=play();
        if(result)
            System.out.println("Film Play:\n "+this);
        return result;
    }

    @Override
    public boolean stop() {
        boolean result=super.stop();
        if(result)
            System.out.println("Film Stop:\n "+this);
        return result;
    }

    @Override
    public String [] addFilm(String nameFilm) {
        nameFilm.trim();
        this.nameFilm=nameFilm.split(",");

        for (int i = 0; i < this.nameFilm.length; i++) {
            this.nameFilm[i]=this.nameFilm[i].trim();
        }
        return this.nameFilm;
    }

    @Override
    public void sort() {
        if (nameFilm.length>1) {
            System.out.println("Фильмы отфильтрованы по алфавиту!");

                Arrays.sort(this.nameFilm);
        }

        else this.nameFilm.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
       // super.toString();
        if(nameFilm!=null) {
            sb.append("Список фильмов: \n");
            for (int i = 0; i < nameFilm.length; i++) {
                sb.append("№" + (i+1) + " - " + nameFilm[i]+"\n");

                sb.append("------------------------------------------------\n");
            }
        }

        return sb.toString();
    }
}
