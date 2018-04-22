package by.epam.ivanStrazhevich.task.factory;

import by.epam.ivanStrazhevich.task.entity.Plane;
import by.epam.ivanStrazhevich.task.entity.Point;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlaneFactoryTest {
    private static final String CORRECT_PLANE_LINE = "1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0";
    private static final String CORRECT_POINT_A_LINE = "1.0 2.0 3.0";
    private static final String CORRECT_POINT_B_LINE = "4.0 5.0 6.0";
    private static final String CORRECT_POINT_C_LINE = "7.0 8.0 9.0";
    PlaneFactory planeFactory;
    PointFactory pointFactory;
    Plane expected;

    @BeforeMethod
    public void setUp() {
        pointFactory = PointFactory.getInstance();
        Point pointA = pointFactory.createFigure(CORRECT_POINT_A_LINE);
        Point pointB = pointFactory.createFigure(CORRECT_POINT_B_LINE);
        Point pointC = pointFactory.createFigure(CORRECT_POINT_C_LINE);
        planeFactory = PlaneFactory.getInstance();
        expected = new Plane(pointA, pointB, pointC);
    }

    @AfterMethod
    public void tearDown() {
        pointFactory = null;
        planeFactory = null;
        expected = null;
    }

    @Test
    public void testCreateFigure() {
        Plane actual = planeFactory.createFigure(CORRECT_PLANE_LINE);
        Assert.assertEquals(actual, expected);
    }
}