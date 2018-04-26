package by.epam.task1A.parser;

import by.epam.task1A.exception.ExtendedException;
import by.epam.task1A.reader.SourceReadable;
import by.epam.task1A.reader.SourceReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class SourceParserTest {
    private static final String CORRECT_DATA_SOURCE = "/Users/ivanstrazhevich/Desktop/IdeaProjects/webDev/data/data.txt";
    private static final String INCORRECT_DATA_SOURCE = "/Users/ivanstrazhevich/Desktop/IdeaProjects/webDev/data/wrongLineData.txt";
    private SourceReadable reader;
    private SourceParsable parser;
    private ArrayList<String> planeDotsList;
    private static final String EXPECTED_PLANE_DATA = "[0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0, " +
            "1.0 2.0 3.0 2.0 1.0 0.0 3.0 4.0 5.0, " +
            "1.0 2.0 3.0 1.0 2.0 3.0 3.0 2.0 6.0]";
    private static final String EXPECTED_POINTS_DATA = "[0.0 0.0 0.0 , 0.0 0.0 0.0 , 0.0 0.0 0.0, " +
            "1.0 2.0 3.0 , 2.0 1.0 0.0 , 3.0 4.0 5.0, " +
            "1.0 2.0 3.0 , 1.0 2.0 3.0 , 3.0 2.0 6.0]";
    String actual;

    @BeforeMethod
    public void setUp() {
        reader = new SourceReader();
        parser = new SourceParser();
        try {
            planeDotsList = (ArrayList<String>)reader.readSource(INCORRECT_DATA_SOURCE);
        } catch (ExtendedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        reader = null;
        parser =null;
    }

    @Test
    public void testParsePointDataProduceListOfCoordinates() {
        actual=parser.excludeWrongLineAtPlaneCoordinatesDataFromList(planeDotsList).toString();
        Assert.assertEquals(actual, EXPECTED_PLANE_DATA);
    }

    @Test
    public void testParsePlaneDataListOfPoints() {
        actual = parser.createDotListFromList(parser.excludeWrongLineAtPlaneCoordinatesDataFromList(planeDotsList)).toString();
        Assert.assertEquals(actual, EXPECTED_POINTS_DATA);
    }
}