package by.it.sevashko.jd03_02.crud;

import by.it.sevashko.jd03_02.beans.Role;

import java.sql.SQLException;

public class RoleCRUD implements CRUD<Role> {

    @Override
    public boolean create(Role bean) throws SQLException {
        return false;
    }

    @Override
    public Role read(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Role bean) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Role bean) {
        return false;
    }
}
