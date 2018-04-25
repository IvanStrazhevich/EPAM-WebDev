package by.epam.task.factory;

import by.epam.task.entity.Plane;
import by.epam.task.entity.Point;
import by.epam.task.exception.ExtendedException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlaneBuilderTest {
    private static final String CORRECT_PLANE_LINE = "1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0";
    private static final String CORRECT_POINT_A_LINE = "1.0 2.0 3.0";
    private static final String CORRECT_POINT_B_LINE = "4.0 5.0 6.0";
    private static final String CORRECT_POINT_C_LINE = "7.0 8.0 9.0";
    private PlaneBuilder planeBuilder;
    private PointBuilder pointBuilder;
    private Plane expected;

    @BeforeMethod
    public void setUp() throws ExtendedException {
        pointBuilder = PointBuilder.getInstance();
        Point pointA = pointBuilder.createFigure(CORRECT_POINT_A_LINE);
        Point pointB = pointBuilder.createFigure(CORRECT_POINT_B_LINE);
        Point pointC = pointBuilder.createFigure(CORRECT_POINT_C_LINE);
        planeBuilder = PlaneBuilder.getInstance();
        expected = new Plane(pointA, pointB, pointC);
    }

    @AfterMethod
    public void tearDown() {
        pointBuilder = null;
        planeBuilder = null;
        expected = null;
    }

    @Test
    public void testCreateFigure() throws ExtendedException {
        Plane actual = planeBuilder.createFigure(CORRECT_PLANE_LINE);
        Assert.assertEquals(actual, expected);
    }
}