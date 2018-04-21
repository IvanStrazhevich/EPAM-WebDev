package by.epam.ivanStrazhevich.task.sourceReader;

import by.epam.ivanStrazhevich.task.exception.ExtendedException;

public interface SourceReadable<T> {
    T readSource(String pointDataSource) throws ExtendedException;
}
