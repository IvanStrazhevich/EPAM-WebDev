package by.epam.ivanStrazhevich.task.validator;

import by.epam.ivanStrazhevich.task.exception.ExtendedException;
import by.epam.ivanStrazhevich.task.sourceReader.SourceReadable;
import by.epam.ivanStrazhevich.task.sourceReader.SourceReader;
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
    public void setUp() {
        sourceValidator = new SourceValidator();
        sourceReader = new SourceReader<ArrayList<String>>();
        sourceList = new ArrayList<>();
        incorrectSourceList = new ArrayList<>();
        try {
            sourceList = sourceReader.readSource(CORRECT_DATA_SOURCE);
            incorrectSourceList = sourceReader.readSource(INCORRECT_DATA_SOURCE);
        } catch (ExtendedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        sourceValidator = null;
        sourceReader = null;
        sourceList = null;
        incorrectSourceList = null;
    }

    @Test
    public void testValidateSourceListWithCorrectList() {
        Assert.assertTrue(sourceValidator.validateSourceList(sourceList));
    }

    @Test
    public void testValidateSourceListWithInCorrectList() {
        Assert.assertFalse(sourceValidator.validateSourceList(incorrectSourceList));
    }

    @Test
    public void testValidateSourceListWithCorrectLine() {
        Assert.assertTrue(sourceValidator.validateCorrectLinePointsForPlane(CORRECT_LINE));
    }

    @Test
    public void testValidateSourceListWithIncorrectList() {
        Assert.assertFalse(sourceValidator.validateCorrectLinePointsForPlane(INCORRECT_LINE));
    }

    @Test
    public void testValidateCoordinateDataForPoint() {
        Assert.assertTrue(sourceValidator.validateCoordinateDataForPoint(CORRECT_LINE.substring(0,4)));
    }
    @Test
    public void testValidateIncorrectCoordinateDataForPoint() {
        Assert.assertFalse(sourceValidator.validateCoordinateDataForPoint(INCORRECT_LINE.substring(0,4)));
    }
}