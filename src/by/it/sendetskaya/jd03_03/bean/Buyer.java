package by.it.sendetskaya.jd03_03.bean;

import java.io.Serializable;
import java.util.Objects;

public class Buyer implements Serializable{
    private int id;
    private String email;
    private String nickname;
    private String password;
    private int fk_roles;

    public Buyer() {
    }

    public Buyer(int id, String email, String nickname, String password, int fk_roles) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.fk_roles = fk_roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFk_roles() {
        return fk_roles;
    }

    public void setFk_roles(int fk_roles) {
        this.fk_roles = fk_roles;
    }

    @Override
    public String toString() {
        return "Buyer {" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", fk_roles=" + fk_roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return id == buyer.id &&
                fk_roles == buyer.fk_roles &&
                Objects.equals(email, buyer.email) &&
                Objects.equals(nickname, buyer.nickname) &&
                Objects.equals(password, buyer.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, nickname, password, fk_roles);
    }
}
