package by.it.sevashko.jd03_02.crud;

import by.it.sevashko.jd03_02.beans.Subscription;

public class SubscriptionCRUD implements CRUD<Subscription> {

    @Override
    public boolean create(Subscription bean) {
        return false;
    }

    @Override
    public Subscription read(int id) {
        return null;
    }

    @Override
    public boolean update(Subscription bean) {
        return false;
    }

    @Override
    public boolean delete(Subscription bean) {
        return false;
    }
}
