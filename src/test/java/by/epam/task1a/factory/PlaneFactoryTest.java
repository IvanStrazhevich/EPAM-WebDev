package by.epam.task1a.factory;

import by.epam.task1a.entity.Plane;
import by.epam.task1a.exception.ExtendedException;
import by.epam.task1a.parser.SourceParser;
import by.epam.task1a.reader.SourceReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class PlaneFactoryTest {
    private static final String CORRECT_DATA_SOURCE = "/Users/ivanstrazhevich/Desktop/IdeaProjects/webDev/data/wrongLinedata.txt";
    private static int EXPECTED_NUMBER_OF_PLANES = 2;
    private PlaneFactory<Plane> planeFactory;
    private SourceParser sourceParser;
    private SourceReader sourceReader;
    ArrayList<String> planeDataList;
    int actual;

    @BeforeMethod
    public void setUp() throws ExtendedException {
        planeFactory = PlaneFactory.getInstance();
        sourceReader = new SourceReader();
        sourceParser = new SourceParser();
        planeDataList = sourceReader.readSource(CORRECT_DATA_SOURCE);
        planeDataList = sourceParser.excludeWrongLineAtPlaneCoordinatesDataFromList(planeDataList);
    }

    @AfterMethod
    public void tearDown() {
        planeFactory = null;
        sourceParser = null;
        sourceReader = null;
        planeDataList = null;
    }

    @Test
    public void testCreateFigures() {
        ArrayList<Plane> planes = planeFactory.createFigures(planeDataList);
        actual = planes.size();
        Assert.assertEquals(actual, EXPECTED_NUMBER_OF_PLANES);
    }
}