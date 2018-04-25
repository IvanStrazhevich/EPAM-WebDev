package by.epam.task.sourceReader;

import by.epam.task.exception.ExtendedException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SourceReadableTest {
    private static final String INCORRECT_DATA_SOURCE = "/ivanstrazhevich/Desktop/data.txt";
    private static final String CORRECT_DATA_SOURCE = "/Users/ivanstrazhevich/Desktop/IdeaProjects/webDev/data/data.txt";
    private SourceReadable reader;

    @BeforeMethod
    public void setUp() {
        reader = new SourceReader();
    }

    @AfterMethod
    public void tearDown() {
        reader = null;
    }

    @Test
    public void testReadSourceReturnsList() {
        try {
            Assert.assertNotNull(reader.readSource(CORRECT_DATA_SOURCE));
        } catch (ExtendedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testReadSourceThrowsException() {
        try {
            Assert.assertThrows((Assert.ThrowingRunnable)reader.readSource(INCORRECT_DATA_SOURCE));
        } catch (ExtendedException e) {
            e.printStackTrace();
        }
    }
}