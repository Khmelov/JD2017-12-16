package by.it.sevashko.jd03_02.crud;

public interface CRUD<T> {

    boolean create(T bean);
    T read(int id);
    boolean update(T bean);
    boolean delete(T bean);
}
