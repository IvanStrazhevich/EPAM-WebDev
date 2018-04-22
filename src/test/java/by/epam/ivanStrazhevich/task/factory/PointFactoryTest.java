package by.epam.ivanStrazhevich.task.factory;

import by.epam.ivanStrazhevich.task.entity.Point;
import by.epam.ivanStrazhevich.task.exception.ExtendedException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PointFactoryTest {
    private static final String CORRECT_POINT_LINE = "1.0 2.0 3.0";
    PointFactory pointfactory;
    Point expected;

    @BeforeMethod
    public void setUp() {
        pointfactory = PointFactory.getInstance();
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