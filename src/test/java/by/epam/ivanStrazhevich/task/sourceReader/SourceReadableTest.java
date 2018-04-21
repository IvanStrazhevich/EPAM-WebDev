package by.epam.ivanStrazhevich.task.sourceReader;

import by.epam.ivanStrazhevich.task.exception.ExtendedException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SourceReadableTest {
    private static final String DEFAULT_DATA_SOURCE = "/Users/ivanstrazhevich/Desktop/data.txt";
    private static final String RESERVED_DATA_SOURCE = "/Users/ivanstrazhevich/Desktop/IdeaProjects/webDev/data/data.txt";
    private SourceReadable reader;
    private String dataSource;

    @BeforeMethod
    public void setUp() {
        reader = new SourceReader();
        dataSource = RESERVED_DATA_SOURCE;
    }

    @AfterMethod
    public void tearDown() {
        reader = null;
        dataSource = null;
    }

    @Test
    public void testReadSourceReturnsList() {
        try {
            Assert.assertNotNull(reader.readSource(dataSource));
        } catch (ExtendedException e) {
            e.printStackTrace();
        }
    }
}