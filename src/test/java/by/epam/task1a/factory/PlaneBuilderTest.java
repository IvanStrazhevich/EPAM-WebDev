package by.epam.task1a.factory;

import by.epam.task1a.entity.Plane;
import by.epam.task1a.entity.Point;
import by.epam.task1a.exception.ExtendedException;
import by.epam.task1b.registrar.PlaneObserver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlaneBuilderTest {
    private static final String CORRECT_PLANE_LINE = "1.0 2.0 8.0 4.0 15.0 6.0 9.0 8.0 10.0";
    private static final String CORRECT_POINT_A_LINE = "1.0 2.0 8.0";
    private static final String CORRECT_POINT_B_LINE = "4.0 15.0 6.0";
    private static final String CORRECT_POINT_C_LINE = "9.0 8.0 10.0";
    private PlaneBuilder planeBuilder;
    private PointBuilder pointBuilder;
    private String expected;
    Plane plane;

    @BeforeMethod
    public void setUp() throws ExtendedException {
        pointBuilder = PointBuilder.getInstance();
        Point pointA = pointBuilder.createFigure(CORRECT_POINT_A_LINE);
        Point pointB = pointBuilder.createFigure(CORRECT_POINT_B_LINE);
        Point pointC = pointBuilder.createFigure(CORRECT_POINT_C_LINE);
        planeBuilder = PlaneBuilder.getInstance();
        plane = new Plane(pointA, pointB, pointC);
        plane.attach(PlaneObserver.getInstance());
        expected = plane.toString();
    }

    @AfterMethod
    public void tearDown() {
        pointBuilder = null;
        planeBuilder = null;
        expected = null;
    }

    @Test
    public void testCreateFigure() throws ExtendedException {
       Plane actualPlane = planeBuilder.createFigure(CORRECT_PLANE_LINE);
       actualPlane.setId(plane.getId());
       String actual = actualPlane.toString();
        Assert.assertEquals(actual, expected);
    }
}