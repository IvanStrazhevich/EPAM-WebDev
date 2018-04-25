package by.epam.task.sourceParser;

import java.util.ArrayList;

public interface SourceParsable<T> {
    ArrayList<String> excludeWrongDataFromList(T dataSource);
    ArrayList<String> createDotListFromList(T planeDataList);
    ArrayList<String> createDotListFromString(String planeDataList);

}

