package by.it.sevashko.jd03_02.crud;

import by.it.sevashko.jd03_02.User;

public class UserCRUD implements CRUD<User>{

    @Override
    public boolean create(User bean) {
        return false;
    }

    @Override
    public User read(int id) {
        return null;
    }

    @Override
    public boolean update(User bean) {
        return false;
    }

    @Override
    public boolean delete(User bean) {
        return false;
    }
}
