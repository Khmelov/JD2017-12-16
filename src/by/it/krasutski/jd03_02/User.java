package by.it.krasutski.jd03_02;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private int ID;
    private String Login, Email, Password, Nickname, PhoneNumber;
    private int roles_ID;

    public User(int ID, String Login, String Email, String Password, String Nickname, String PhoneNumber, int roles_ID) {
        this.ID = ID;
        this.Login = Login;
        this.Email = Email;
        this.Password = Password;
        this.Nickname = Nickname;
        this.PhoneNumber = PhoneNumber;
        this.roles_ID = roles_ID;
    }

    public User() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String Nickname) {
        this.Nickname = Nickname;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public int getRoles_ID() {
        return roles_ID;
    }

    public void setRoles_ID(int roles_ID) {
        this.roles_ID = roles_ID;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Login='" + Login + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", Nickname='" + Nickname + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", roles_ID=" + roles_ID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return ID == user.ID &&
                roles_ID == user.roles_ID &&
                Objects.equals(Login, user.Login) &&
                Objects.equals(Email, user.Email) &&
                Objects.equals(Password, user.Password) &&
                Objects.equals(Nickname, user.Nickname) &&
                Objects.equals(PhoneNumber, user.PhoneNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID, Login, Email, Password, Nickname, PhoneNumber, roles_ID);
    }
}
