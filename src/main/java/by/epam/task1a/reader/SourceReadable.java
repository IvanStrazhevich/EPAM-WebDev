package by.epam.task1a.reader;

import by.epam.task1a.exception.ExtendedException;

public interface SourceReadable<T> {
    T readSource(String pointDataSource) throws ExtendedException;
}
