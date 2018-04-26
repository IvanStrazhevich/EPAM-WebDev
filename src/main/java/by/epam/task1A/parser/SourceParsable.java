package by.epam.task1A.parser;

import java.util.ArrayList;

public interface SourceParsable<T> {
    ArrayList<String> excludeWrongLineAtPlaneCoordinatesDataFromList(T dataSource);

    ArrayList<String> createDotListFromList(T planeDataList);

    ArrayList<String> createDotListFromString(String planeDataList);

}

