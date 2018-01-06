package by.it.patsko.jd01_08;

abstract class Surgeon implements Doctor {
    private String specialty;       //специальность врача
    private String Treatment;       //лечение

    public Surgeon(String specialty) {
        this.specialty = specialty;
    }
}
