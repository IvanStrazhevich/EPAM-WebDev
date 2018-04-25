package by.epam.task.factory;

import by.epam.task.entity.Point;
import by.epam.task.exception.ExtendedException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PointBuilderTest {
    private static final String CORRECT_POINT_LINE = "1.0 2.0 3.0";
    private PointBuilder pointfactory;
    private Point expected;

    @BeforeMethod
    public void setUp() {
        pointfactory = PointBuilder.getInstance();
        expected = new Point(1.0, 2.0, 3.0);
    }

    @AfterMethod
    public void tearDown() {
        pointfactory = null;
        expected = null;
    }

    @Test
    public void testCreateFigure() throws ExtendedException {
        Point actual = pointfactory.createFigure(CORRECT_POINT_LINE);
        Assert.assertEquals(actual, expected);
    }
}