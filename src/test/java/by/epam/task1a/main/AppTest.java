package by.epam.task1a.main;

import by.epam.task1a.entity.Plane;
import by.epam.task1a.exception.ExtendedException;
import by.epam.task1a.factory.FigureFactory;
import by.epam.task1a.factory.PlaneFactory;
import by.epam.task1a.parser.SourceParser;
import by.epam.task1a.reader.SourceReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AppTest {
    private static final String CORRECT_DATA_SOURCE = "/Users/ivanstrazhevich/Desktop/IdeaProjects/webDev/data/wrongLineData.txt";
    private static final int EXPECTED_NUMBER_OF_PLANES = 2;

    @Test
    public void AppTest() throws ExtendedException {
        SourceReader sourceReader = new SourceReader();
        SourceParser sourceParser = new SourceParser();
        FigureFactory planeFactory = PlaneFactory.getInstance();
        ArrayList<String> planeDataList = sourceReader.readSource(CORRECT_DATA_SOURCE);
        planeDataList = sourceParser.excludeWrongLineAtPlaneCoordinatesDataFromList(planeDataList);
        ArrayList<Plane> planes = planeFactory.createFigures(planeDataList);
        int actual = planes.size();
        Assert.assertEquals(actual, EXPECTED_NUMBER_OF_PLANES);
    }
}
