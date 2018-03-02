package by.it.kozlov.jd03_02;

import by.it.kozlov.jd03_02.beans.Role;
import by.it.kozlov.jd03_02.crud.RoleCRUD;

import java.sql.SQLException;

public class RunRole {
    public static void main(String[] args) throws SQLException {
        RoleCRUD roleCRUD = new RoleCRUD();
        Role role = roleCRUD.read(2);
        System.out.println(role);

        role = roleCRUD.read("admin");
        System.out.println(role);
    }


}
