package by.it.vshelukhin.jd03_05.java.dao.beans;

public class Zakaz {

    private int id = 0;
    private int students_id = 0;
    private int works_id = 0;


    public Zakaz(){
        super();
    }

    public Zakaz(int id, int students_id, int works_id){
        super();
        this.id = id;
        this.students_id = students_id;
        this.works_id = works_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudents_id(int students_id) {
        this.students_id = students_id;
    }

    public void setWorks_id(int works_id) {
        this.works_id = works_id;
    }

    public int getId() {
        return id;
    }

    public int getStudents_id() {
        return students_id;
    }

    public int getWorks_id() {
        return works_id;
    }

    @Override
    public String toString() {
        return "Zakaz{" +
                "id=" + id +
                ", students_id=" + students_id +
                ", works_id=" + works_id +
                '}';
    }
}
