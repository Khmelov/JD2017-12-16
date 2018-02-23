package by.it.karpeichyk.jd03_03.BEAN;

import java.io.Serializable;

/**
 * Created by user on 17.02.2018.
 */
public class User implements  Serializable {
    public User() {
    }

    private int id =0;
    private String login;
    private String email;
    private String pasword;
    private int fk_roles;

    public User(int id, String login, String email, String pasword, int fk_roles){
        this.id=id;
        this.login=login;
        this.email=email;
        this.pasword=pasword;
        this.fk_roles=fk_roles;
    }

    public  int getId (){return id;}
    public void setId (int id){this.id = id;}

    public  String getLogin (){return login;}
    public  void  setLogin(String login){this.login = login;}

    public  String getEmail (){return email;}
    public  void  setEmail(String email){this.email = email;}

    public  String getPasword (){return pasword;}
    public  void  setPasword(String pasword){this.pasword = pasword;}

    public  int getFk_roles (){return fk_roles;}
    public  void  setFk_roles(int fk_roles){this.fk_roles = fk_roles;}


    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (pasword != null ? pasword.hashCode() : 0);
        result = 31 * result + fk_roles;

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;

        if (id != user.id) return  false;
        if (fk_roles != user.fk_roles) return  false;
        if (login != null ? !login.equals(user.login) : user.login != null) return  false;
        if (email != null ? !email.equals(user.email) : user.email != null) return  false;
        return pasword != null ? pasword.equals(user.pasword) : user.pasword == null;
    }

    @Override
    public String toString() {

        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", pasword='" + pasword + '\'' +
                ", fk_roles=" + fk_roles +
                '}';
    }


}
