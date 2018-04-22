package by.epam.ivanStrazhevich.task.sourceParser;

import java.util.ArrayList;

public interface SourceParsable<T> {
    ArrayList<String> excludeWrongDataFromList(T dataSource);
    ArrayList<String> createDotData(ArrayList<String> planeDataList);
}

