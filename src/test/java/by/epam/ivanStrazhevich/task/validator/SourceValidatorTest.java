package by.epam.ivanStrazhevich.task.validator;

import by.epam.ivanStrazhevich.task.exception.ExtendedException;
import by.epam.ivanStrazhevich.task.sourceReader.SourceReadable;
import by.epam.ivanStrazhevich.task.sourceReader.SourceReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SourceValidatorTest {
    private static final String CORRECT_LINE = "1.0 2.0 3.0 2.0 1.0 0.0 3.0 4.0 5.0";
    private static final String RESERVED_DATA_SOURCE = "/Users/ivanstrazhevich/Desktop/IdeaProjects/webDev/data/data.txt";
    private SourceValidatable sourceValidator;
    private ArrayList<String> sourceList;
    private ArrayList<String> sourceListOneLine;
    private SourceReadable<ArrayList<String>> sourceReader;

    @BeforeMethod
    public void setUp(){
        sourceValidator = new SourceValidator();
        sourceReader = new SourceReader<ArrayList<String>>();
        sourceList = new ArrayList<>();
        try {
            sourceList = sourceReader.readSource(RESERVED_DATA_SOURCE);
        } catch (ExtendedException e) {
            e.printStackTrace();
        }
        sourceListOneLine = new ArrayList<>();
        sourceListOneLine.add(CORRECT_LINE);
    }

    @AfterMethod
    public void tearDown(){
        sourceValidator = null;
        sourceReader = null;
        sourceList = null;
        sourceListOneLine = null;
    }

    @Test
    public void testValidateSourceListWithCorrectLine() throws Exception {
        Assert.assertTrue(sourceValidator.validateSourceList(sourceListOneLine));
    }
    @Test
    public void testValidateSourceListWithCorrectList() throws Exception {
        Assert.assertTrue(sourceValidator.validateSourceList(sourceList));
    }
}