package by.epam.task.action;

import by.epam.task1A.action.FigureCalculation;
import by.epam.task1A.entity.Plane;
import by.epam.task1A.entity.Point;
import by.epam.task1A.exception.ExtendedException;
import by.epam.task1A.factory.FigureBuilder;
import by.epam.task1A.factory.PlaneBuilder;
import by.epam.task1A.factory.PointBuilder;
import by.epam.task1A.parser.SourceParsable;
import by.epam.task1A.parser.SourceParser;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class FigureCalculationTest {
    private static final String CORRECT_PLANE_DATA = "1.0 1.0 1.0 2.0 2.0 1.0 3.0 3.0 1.0";
    private static final String INCORRECT_PLANE_DATA = "1.0 1.0 1.0 2.0 2.0 2.0 3.0 3.0 3.0";
    private FigureBuilder pointBuilder;
    private FigureBuilder planeBuilder;
    private SourceParsable sourceParser;
    private ArrayList<Point> pointList;
    ArrayList<String> dataForPoints;
    FigureCalculation figureCalculation;

    @BeforeClass
    public void setUp() {
        pointBuilder = PointBuilder.getInstance();
        planeBuilder = PlaneBuilder.getInstance();
        sourceParser = new SourceParser();
        figureCalculation = new FigureCalculation();

    }

    @AfterClass
    public void tearDown() {
        pointBuilder = null;
        planeBuilder = null;
        sourceParser = null;
        figureCalculation = null;

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
            Point point = (Point) pointBuilder.createFigure(dot);
            pointList.add(point);
        }
        Point pointA = pointList.get(0);
        Point pointB = pointList.get(1);
        Point pointC = pointList.get(2);
        Assert.assertTrue(figureCalculation.checkIfThreeDotsIsPlane(pointA, pointB, pointC));
    }

    @Test
    public void testCheckIfPlanePerpendicularDatumLineTrue() throws ExtendedException {
        Plane plane = (Plane) planeBuilder.createFigure(CORRECT_PLANE_DATA);
        Assert.assertTrue(figureCalculation.checkIfPlanePerpendicularDatumLine(plane));
    }
    @Test
    public void testCheckIfThreeDotsIsPlaneFalse() throws ExtendedException {
        dataForPoints = sourceParser.createDotListFromString(INCORRECT_PLANE_DATA);
        pointList = new ArrayList<>();
        for (String dot : dataForPoints
                ) {
            Point point = (Point) pointBuilder.createFigure(dot);
            pointList.add(point);
        }
        Point pointA = pointList.get(0);
        Point pointB = pointList.get(1);
        Point pointC = pointList.get(2);
        Assert.assertFalse(figureCalculation.checkIfThreeDotsIsPlane(pointA, pointB, pointC));
    }

    @Test
    public void testCheckIfPlanePerpendicularDatumLineFalse() throws ExtendedException {
        Plane plane = (Plane) planeBuilder.createFigure(INCORRECT_PLANE_DATA);
        Assert.assertFalse(figureCalculation.checkIfPlanePerpendicularDatumLine(plane));
    }
}