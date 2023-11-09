package service;

public interface Service<T> {

    void showMenu();
    void add(T obj);
    void remove(T obj);
    void getAll();

}
