package by.it.viktorbrui.jd03_02;

import java.io.Serializable;

class User implements Serializable{

    public User(int id, String nickname, String email, String password, String address, int phone, int FK_Roles) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.FK_Roles = FK_Roles;
    }

    public User() {
    }

    private int id;
    private String nickname;
    private String email;
    private String password;
    private String address;
    private int phone;
    private int FK_Roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getFK_Roles() {
        return FK_Roles;
    }

    public void setFK_Roles(int FK_Roles) {
        this.FK_Roles = FK_Roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", password='" + address + '\'' +
                ", phone=" + phone +
                ", FK_Roles=" + FK_Roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (phone != user.phone) return false;
        if (FK_Roles != user.FK_Roles) return false;
        if (nickname != null ? !nickname.equals(user.nickname) : user.nickname != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;

        return password != null ? password.equals(user.password) : user.password == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + phone;
        result = 31 * result + FK_Roles;
        return result;
    }
}
