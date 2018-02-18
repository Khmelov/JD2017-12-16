package by.it.sevashko.jd03_02.crud;

import by.it.sevashko.jd03_02.Role;

public class RoleCRUD implements CRUD<Role> {

    @Override
    public boolean create(Role bean) {
        return false;
    }

    @Override
    public Role read(int id) {
        return null;
    }

    @Override
    public boolean update(Role bean) {
        return false;
    }

    @Override
    public boolean delete(Role bean) {
        return false;
    }
}
