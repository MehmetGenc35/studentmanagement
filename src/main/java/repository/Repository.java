package repository;

public interface Repository<T> {

    void save(T obj);
    void remove(T obj);
    void getAll();
    T getById(Long id);
}
