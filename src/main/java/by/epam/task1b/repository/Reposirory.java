package by.epam.task1b.repository;

import java.util.List;

public interface Reposirory<T> {
    boolean add(T item);
    boolean remove(T item);
    boolean update(T item);
    List<T> query(QuerySpecification querySpecification);
}
