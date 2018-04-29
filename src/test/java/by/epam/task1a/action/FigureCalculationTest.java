package by.epam.task1a.action;

import by.epam.task1a.entity.Plane;
import by.epam.task1a.entity.Point;
import by.epam.task1a.exception.ExtendedException;
import by.epam.task1a.factory.FigureBuilder;
import by.epam.task1a.factory.PlaneBuilder;
import by.epam.task1a.factory.PointBuilder;
import by.epam.task1a.parser.SourceParsable;
import by.epam.task1a.parser.SourceParser;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class FigureCalculationTest {
    private static final String CORRECT_PLANE_DATA_FOR_ANGLE_COUNT = "1.0 4.0 9.0 4.0 6.0 7.0 -3.0 14.0 29.0";
    private static final String CORRECT_PLANE_DATA = "8.0 7.0 1.0 2.0 5.0 1.0 3.0 4.0 1.0";
    private static final String INCORRECT_PLANE_DATA = "1.0 1.0 1.0 2.0 2.0 2.0 3.0 3.0 3.0";
    private FigureBuilder pointBuilder;
    private FigureBuilder planeBuilder;
    private SourceParsable sourceParser;
    private ArrayList<Point> pointList;
    private static final int POINT_A = 0;
    private static final int POINT_B = 1;
    private static final int POINT_C = 2;

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
    public void testCountAngleToXYPlane() throws ExtendedException {
        figureCalculation.countAngleToXYPlaneGrad((Plane) planeBuilder.createFigure(CORRECT_PLANE_DATA_FOR_ANGLE_COUNT));
    }
    @Test
    public void testCountAngleToXZPlane() throws ExtendedException {
        figureCalculation.countAngleToXZPlaneGrad((Plane) planeBuilder.createFigure(CORRECT_PLANE_DATA_FOR_ANGLE_COUNT));
    }
    @Test
    public void testCountAngleToYZPlane() throws ExtendedException {
        figureCalculation.countAngleToYZPlaneGrad((Plane) planeBuilder.createFigure(CORRECT_PLANE_DATA_FOR_ANGLE_COUNT));
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
        Point pointA = pointList.get(POINT_A);
        Point pointB = pointList.get(POINT_B);
        Point pointC = pointList.get(POINT_C);
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