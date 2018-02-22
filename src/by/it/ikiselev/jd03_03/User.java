package by.it.ikiselev.jd03_03;


public class User {

    private int id = 0;
    private String login;
    private String password;
    private String email;
    private Integer fk_roles = 0;

    public User() {
    }

    public User(int id, String login, String password, String email, Integer fk_Role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fk_roles = fk_Role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Integer getFk_Role() {
        return fk_roles;
    }

    public void setFk_Role(Integer fk_Role) {
        this.fk_roles = fk_Role;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", Role=" + fk_roles +
                '}';
    }
}
