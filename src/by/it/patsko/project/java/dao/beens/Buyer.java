package by.it.patsko.project.java.dao.beens;

import java.util.Objects;

public class Buyer {
    private int id;
    private String login;
    private String password;
    private String email;
    private int Roles_id;

    public Buyer() {
    }

    public Buyer(int id, String login, String password, String email, int roles_id) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        Roles_id = roles_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoles_id() {
        return Roles_id;
    }

    public void setRoles_id(int roles_id) {
        Roles_id = roles_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return id == buyer.id &&
                Roles_id == buyer.Roles_id &&
                Objects.equals(login, buyer.login) &&
                Objects.equals(password, buyer.password) &&
                Objects.equals(email, buyer.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, password, email, Roles_id);
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", Roles_id=" + Roles_id +
                '}';
    }
}
