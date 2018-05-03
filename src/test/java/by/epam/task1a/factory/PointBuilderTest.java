package by.epam.task1a.factory;

import by.epam.task1a.entity.Point;
import by.epam.task1a.exception.ExtendedException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PointBuilderTest {
    private static final String CORRECT_POINT_LINE = "1.0 2.0 3.0";
    private PointBuilder pointfactory;
    private double x =1.0;
    private double y =2.0;
    private double z =3.0;
    private String expected;

    @BeforeMethod
    public void setUp() {
        pointfactory = PointBuilder.getInstance();
        expected = new Point(x, y, z).toString();
    }

    @AfterMethod
    public void tearDown() {
        pointfactory = null;
        expected = null;
    }

    @Test
    public void testCreateFigure() throws ExtendedException {
        String actual = pointfactory.createPoint(CORRECT_POINT_LINE).toString();
        Assert.assertEquals(actual, expected);
    }
}