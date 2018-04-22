package by.epam.ivanStrazhevich.task.sourceParser;

import java.util.ArrayList;

public interface SourceParsable<T> {
    ArrayList<String> excludeWrongDataFromList(T dataSource);
    ArrayList<String> createDotDataFromList(T planeDataList);
    ArrayList<String> createDotDataFromString(String planeDataList);

}

