package by.epam.task1a.validator;

import by.epam.task1a.exception.ExtendedException;
import by.epam.task1a.reader.SourceReadable;
import by.epam.task1a.reader.SourceReader;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class SourceValidatorTest {
    private static final String CORRECT_LINE = "1.0 2.0 3.0 2.0 1.0 0.0 3.0 4.0 5.0";
    private static final String INCORRECT_LINE = "1.z0 2.0 3.0 2.0 1.0 0.0 3.0 4.0 5.0";
    private static final String CORRECT_DATA_SOURCE = "/Users/ivanstrazhevich/Desktop/IdeaProjects/webDev/data/data.txt";
    private static final String INCORRECT_DATA_SOURCE = "/Users/ivanstrazhevich/Desktop/IdeaProjects/webDev/data/wrongLineData.txt";
    private SourceValidatable sourceValidator;
    private ArrayList<String> sourceList;
    private ArrayList<String> incorrectSourceList;
    private SourceReadable<ArrayList<String>> sourceReader;

    @BeforeClass
    public void setUp() throws ExtendedException {
        sourceValidator = new SourceValidator();
        sourceReader = new SourceReader<ArrayList<String>>();
        sourceList = new ArrayList<>();
        incorrectSourceList = new ArrayList<>();
        sourceList = sourceReader.readSource(CORRECT_DATA_SOURCE);
        incorrectSourceList = sourceReader.readSource(INCORRECT_DATA_SOURCE);
    }

    @AfterClass
    public void tearDown() {
        sourceValidator = null;
        sourceReader = null;
        sourceList = null;
        incorrectSourceList = null;
    }

    @Test
    public void testValidateSourceListWithCorrectListTrue() {
        Assert.assertTrue(sourceValidator.validateSourceList(sourceList));
    }

    @Test
    public void testValidateSourceListWithInCorrectListFalse() {
        Assert.assertFalse(sourceValidator.validateSourceList(incorrectSourceList));
    }

    @Test
    public void testValidateSourceListWithCorrectLineTrue() {
        Assert.assertTrue(sourceValidator.validateCorrectLinePointsForPlane(CORRECT_LINE));
    }

    @Test
    public void testValidateSourceListWithIncorrectListFalse() {
        Assert.assertFalse(sourceValidator.validateCorrectLinePointsForPlane(INCORRECT_LINE));
    }

    @Test
    public void testValidateCoordinateDataForPointTrue() {
        Assert.assertTrue(sourceValidator.validateCoordinatesForPoint(CORRECT_LINE.substring(0, 4)));
    }

    @Test
    public void testValidateIncorrectCoordinateDataForPointFalse() {
        Assert.assertFalse(sourceValidator.validateCoordinatesForPoint(INCORRECT_LINE.substring(0, 4)));
    }
}