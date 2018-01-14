package by.it.karpeichyk.jd01_08;

/**
 * Created by user on 08.01.2018.
 */
abstract  class Student implements Applicant {
    boolean reading;
    boolean writing;
    boolean attendThelecture;
     
    private   String  study;
    private boolean sleep;

    public void setStudy(String study) {this.study = study;}


    public  Student(){
        reading=true;
        writing=true;
      
    }
    public Student(String study){
        reading=false;
        writing=false;
        
        this.study=study;
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
        sb.append("++++++++++++++++++++++++++++++\n");
        sb.append(attendThelecture? "Отсуствовал\n" : "Присутствовал\n");
        sb.append(sleep? "Не спал  "+study+"\n":"Не спал\n");
       // System.out.println();
        sb.append(reading? "Читал\n" : "Не читал\n");
       // System.out.println();
        sb.append(writing? "Писал\n":"Не писал\n");
        sb.append("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n");
        return sb.toString();
    }
    @Override
    public boolean reading() {
        if (! reading|| sleep) {
            reading=true;
            sleep=true;
            return true;
        }
        else
            return false;
    }
    @Override
    public boolean writing(){
        if (writing){
            reading=true;
            return true;
        }
        return false;
    }
    }


