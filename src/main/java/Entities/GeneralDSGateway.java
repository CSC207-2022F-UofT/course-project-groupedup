package Entities;

public interface GeneralDSGateway<T, E> {
    void save(T object);
    boolean existsByIdentifier(E identifier);
}
