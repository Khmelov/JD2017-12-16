package by.it.karpeichyk.jd01_08;

/**
 * Created by user on 08.01.2018.
 */
abstract  class Student implements Applicant {
    boolean reading;
    boolean writing;
    boolean learn;
    boolean attendThelecture;
     boolean sleep;
    private String exam;

    public void setExam(String exam){this.exam=exam;}


    public void Student(boolean attendThelecture) {
        this.attendThelecture = attendThelecture;
    }
    public Student(boolean attendThelecture){
        reading=true;
        writing=true;
        learn=true;
        sleep= false;
        this.attendThelecture=attendThelecture;


    }
    public  Student(){
        reading=true;
        writing=true;
        learn=true;
        sleep= false;
    }
    @Override
    public  boolean sleep(){
        if (!sleep || attendThelecture) {
            sleep=true;
            attendThelecture=false;
            return true;
        }
        else
            return false;
    }


    @Override
    public  String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(attendThelecture ? "Присутствовал\n" : "Отсуствовал\n");
        return sb.toString();

    }
    @Override
    public boolean reading() {
        if (! reading|| writing) {
            reading=true;
            writing=false;
            return true;
        }
        else
            return false;
    }
    @Override
    public boolean writing(){
        if (writing){
            reading=false;
            return true;
        }
        return false;
    }
    }


