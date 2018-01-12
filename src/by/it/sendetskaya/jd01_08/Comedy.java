package by.it.sendetskaya.jd01_08;

import java.util.Arrays;


public class Comedy extends DomesticFilm {

    private String [] nameFilm;

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
        nameFilm=nameFilm.trim();
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

        else Arrays.toString(this.nameFilm);
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
       // super.toString();
        if(nameFilm!=null) {
            sb.append("Список фильмов: \n");
            for (int i = 0; i < nameFilm.length; i++) {
                sb.append("№").append(i + 1).append(" - ").append(nameFilm[i]).append("\n");

                sb.append("------------------------------------------------\n");
            }
        }

        return sb.toString();
    }
}
