package by.epam.ivanStrazhevich.task.sourceParser;

import java.util.ArrayList;

public interface SourceParsable<T> {
    ArrayList<Double> parsePointDataToCoordinatesList(T dataSource);
}
