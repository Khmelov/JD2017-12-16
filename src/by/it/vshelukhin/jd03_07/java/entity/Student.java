package by.it.vshelukhin.jd03_07.java.entity;

public class Student {

    int id = 0;
    String login = "";
    String password = "";
    String univer = "";
    int kurs = 0;
    String facultet = "";
    double price = 0.0;
    int role = 2;

    public Student() {
        super();
    }

    public Student(int id, String login, String password, String univer, int kurs, String facultet, double price, int role) {
        this();
        this.id = id;
        this.login = login;
        this.password = password;
        this.univer = univer;
        this.kurs = kurs;
        this.facultet = facultet;
        this.price = price;
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUniver(String univer) {
        this.univer = univer;
    }

    public void setKurs(int kurs) {
        this.kurs = kurs;
    }

    public void setFacultet(String facultet) {
        this.facultet = facultet;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getUniver() {

        return univer;
    }

    public int getKurs() {
        return kurs;
    }

    public String getFacultet() {
        return facultet;
    }

    public double getPrice() {
        return price;
    }

    public int getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", univer='" + univer + '\'' +
                ", kurs=" + kurs +
                ", facultet='" + facultet + '\'' +
                ", price=" + price +
                ", role=" + role +
                '}';
    }
}
