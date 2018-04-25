package by.epam.task.action;

import by.epam.task.entity.Plane;
import by.epam.task.entity.Point;
import by.epam.task.exception.ExtendedException;
import by.epam.task.factory.FigureBuilder;
import by.epam.task.factory.PlaneBuilder;
import by.epam.task.factory.PointBuilder;
import by.epam.task.sourceParser.SourceParsable;
import by.epam.task.sourceParser.SourceParser;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class PlaneCalculationTest {
    private static final String CORRECT_PLANE_DATA = "1.0 1.0 1.0 2.0 2.0 1.0 3.0 3.0 1.0";
    private static final String INCORRECT_PLANE_DATA = "1.0 1.0 1.0 2.0 2.0 2.0 3.0 3.0 3.0";
    private FigureBuilder pointFactory;
    private FigureBuilder planeFactory;
    private SourceParsable sourceParser;
    private ArrayList<Point> pointList;
    ArrayList<String> dataForPoints;
    PlaneCalculation planeCalculation;

    @BeforeClass
    public void setUp() {
        pointFactory = PointBuilder.getInstance();
        planeFactory = PlaneBuilder.getInstance();
        sourceParser = new SourceParser();
        planeCalculation = new PlaneCalculation();

    }

    @AfterClass
    public void tearDown() {
        pointFactory = null;
        planeFactory = null;
        sourceParser = null;
        planeCalculation = null;

    }

    @Test
    public void testCountAngleToAxis() {
    }

    @Test
    public void testCheckIfThreeDotsIsPlaneTrue() throws ExtendedException {
        dataForPoints = sourceParser.createDotListFromString(CORRECT_PLANE_DATA);
        pointList = new ArrayList<>();
        for (String dot : dataForPoints
                ) {
            Point point = (Point) pointFactory.createFigure(dot);
            pointList.add(point);
        }
        Point pointA = pointList.get(0);
        Point pointB = pointList.get(1);
        Point pointC = pointList.get(2);
        Assert.assertTrue(planeCalculation.checkIfThreeDotsIsPlane(pointA, pointB, pointC));
    }

    @Test
    public void testCheckIfPlanePerpendicularDatumLineTrue() throws ExtendedException {
        Plane plane = (Plane) planeFactory.createFigure(CORRECT_PLANE_DATA);
        Assert.assertTrue(planeCalculation.checkIfPlanePerpendicularDatumLine(plane));
    }
    @Test
    public void testCheckIfThreeDotsIsPlaneFalse() throws ExtendedException {
        dataForPoints = sourceParser.createDotListFromString(INCORRECT_PLANE_DATA);
        pointList = new ArrayList<>();
        for (String dot : dataForPoints
                ) {
            Point point = (Point) pointFactory.createFigure(dot);
            pointList.add(point);
        }
        Point pointA = pointList.get(0);
        Point pointB = pointList.get(1);
        Point pointC = pointList.get(2);
        Assert.assertFalse(planeCalculation.checkIfThreeDotsIsPlane(pointA, pointB, pointC));
    }

    @Test
    public void testCheckIfPlanePerpendicularDatumLineFalse() throws ExtendedException {
        Plane plane = (Plane) planeFactory.createFigure(INCORRECT_PLANE_DATA);
        Assert.assertFalse(planeCalculation.checkIfPlanePerpendicularDatumLine(plane));
    }
}