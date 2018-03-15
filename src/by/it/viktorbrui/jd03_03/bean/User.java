package by.it.viktorbrui.jd03_03.bean;

import java.io.Serializable;

public class User implements Serializable{

    public User(int ID, String NickName, String Email, String Password, String Address, int Phone, int FK_Roles) {
        this.ID = ID;
        this.NickName = NickName;
        this.Email = Email;
        this.Password = Password;
        this.Address = Address;
        this.Phone = Phone;
        this.FK_Roles = FK_Roles;
    }

    public User(int id, String nickname, String email, String address, String phone, int fk_roles) {
    }

    private int ID;
    private String NickName;
    private String Email;
    private String Password;
    private String Address;
    private int Phone;
    private int FK_Roles;

    public int getId() {
        return ID;
    }

    public void setId(int ID) {
        this.ID = ID;
    }

    public String getNickname() {
        return NickName;
    }

    public void setNickname(String NickName) {
        this.NickName = NickName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {return Address;}

    public void setAddress(String Address) {this.Address = Address;}

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    public int getPhone() {
        return Phone;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
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
                "ID=" + ID +
                ", NickName='" + NickName + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", Address='" + Address + '\'' +
                ", Phone=" + Phone +
                ", FK_Roles=" + FK_Roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (ID != user.ID) return false;
        if (Phone != user.Phone) return false;
        if (FK_Roles != user.FK_Roles) return false;
        if (NickName != null ? !NickName.equals(user.NickName) : user.NickName != null) return false;
        if (Email != null ? !Email.equals(user.Email) : user.Email != null) return false;
        if (Address != null ? !Address.equals(user.Address) : user.Address != null) return false;

        return Password != null ? Password.equals(user.Password) : user.Password == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (NickName != null ? NickName.hashCode() : 0);
        result = 31 * result + (Email != null ? Email.hashCode() : 0);
        result = 31 * result + (Password != null ? Password.hashCode() : 0);
        result = 31 * result + (Address != null ? Address.hashCode() : 0);
        result = 31 * result + Phone;
        result = 31 * result + FK_Roles;
        return result;
    }
}
