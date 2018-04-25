package by.epam.task1A.reader;

import by.epam.task1A.exception.ExtendedException;

public interface SourceReadable<T> {
    T readSource(String pointDataSource) throws ExtendedException;
}
