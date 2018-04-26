package by.epam.task1a.reader;

import by.epam.task1a.exception.ExtendedException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SourceReadableTest {
    private static final String INCORRECT_DATA_SOURCE = "/ivanstrazhevich/Desktop/data.txt";
    private static final String CORRECT_DATA_SOURCE = "/Users/ivanstrazhevich/Desktop/IdeaProjects/webDev/data/data.txt";
    private static final String NULL_DATA_SOURCE = null;
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
    public void testReadSourceReturnsList() throws ExtendedException {
            Assert.assertNotNull(reader.readSource(CORRECT_DATA_SOURCE));
    }

    @Test(expectedExceptions = ExtendedException.class)
    public void testReadSourceThrowsException() throws ExtendedException {
        Assert.assertThrows((Assert.ThrowingRunnable) reader.readSource(INCORRECT_DATA_SOURCE));
    }

    @Test(expectedExceptions = ExtendedException.class)
    public void testReadSourceThrowsExceptionOnNullSource() throws ExtendedException {
        Assert.assertThrows((Assert.ThrowingRunnable) reader.readSource(NULL_DATA_SOURCE));
    }
}