package by.epam.task1b.repository;

import by.epam.task1b.repository.specification.QuerySpecification;

import java.util.List;

public interface Reposirory<T> {
    boolean add(T item);
    boolean remove(T item);
    boolean update(T item);
    List<T> query(QuerySpecification querySpecification);
}
