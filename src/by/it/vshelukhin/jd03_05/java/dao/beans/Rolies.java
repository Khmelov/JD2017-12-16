package by.it.vshelukhin.jd03_05.java.dao.beans;

public class Rolies {

    private int id = 0;
    private String role = "";

    public Rolies(){
        super();
    }

    public Rolies(int id, String role){
        this.id = id;
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Rolies{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
