package by.it.sevashko.jd03_02.crud;

import by.it.sevashko.jd03_02.beans.Publication;

public class PublicationCRUD implements CRUD<Publication> {

    @Override
    public boolean create(Publication bean) {
        return false;
    }

    @Override
    public Publication read(int id) {
        return null;
    }

    @Override
    public boolean update(Publication bean) {
        return false;
    }

    @Override
    public boolean delete(Publication bean) {
        return false;
    }
}
