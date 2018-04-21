package by.epam.ivanStrazhevich.task.sourceParser;

import by.epam.ivanStrazhevich.task.sourceReader.SourceReadable;
import by.epam.ivanStrazhevich.task.sourceReader.SourceReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class SourceParserFromListTest {
    private static final String RESERVED_DATA_SOURCE = "/Users/ivanstrazhevich/Desktop/IdeaProjects/webDev/data/data.txt";
    private SourceReadable reader;
    private SourceParsable parser;
    private String dataSource;
    private ArrayList<String> planeDotsList;

    @BeforeMethod
    public void setUp() {
        reader = new SourceReader();
        parser = new SourceParserFromList();
        dataSource = RESERVED_DATA_SOURCE;
    }

    @AfterMethod
    public void tearDown() {
        reader = null;
        dataSource = null;
        parser =null;
    }

    @Test
    public void testParsePointDataProduceListOfCoordinates() throws Exception {
        planeDotsList = (ArrayList<String>)reader.readSource(dataSource);
        Assert.assertNotNull(parser.parsePointDataToCoordinatesList(planeDotsList));
    }

    @Test
    public void testParsePlaneData() throws Exception {
    }
}