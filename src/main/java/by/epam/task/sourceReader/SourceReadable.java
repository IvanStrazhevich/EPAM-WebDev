package by.epam.task.sourceReader;

import by.epam.task.exception.ExtendedException;

public interface SourceReadable<T> {
    T readSource(String pointDataSource) throws ExtendedException;
}
