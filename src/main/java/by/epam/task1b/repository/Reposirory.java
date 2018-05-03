package by.epam.task1b.repository;

import by.epam.task1a.entity.Figure;
import by.epam.task1b.repository.specification.QuerySpecification;

import java.util.ArrayList;
import java.util.List;

public interface Reposirory<T> {
    boolean add(T item);
    boolean remove(T item);
    boolean update(T item);
    boolean addAll(ArrayList<T> list);
    List<T> query(QuerySpecification querySpecification);
}
