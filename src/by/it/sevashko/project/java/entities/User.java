package by.it.sevashko.project.java.entities;

import java.util.Objects;

public class User {

    private int id;
    private String Login;
    private String password;
    private String name;
    private String lastName;
    private String email;
    private int fk_role;

    public User() {
    }

    public User(int id, String login, String password, String name, String lastName, String email, int fk_role) {
        this.id = id;
        Login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.fk_role = fk_role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFk_role(int fk_role) {
        this.fk_role = fk_role;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getFk_role() {
        return fk_role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(Login, user.Login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(fk_role, user.fk_role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, Login, password, name, lastName, email, fk_role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Login='" + Login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", fk_role='" + fk_role + '\'' +
                '}';
    }
}
