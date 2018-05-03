package by.epam.task1b.repository;

import by.epam.task1a.entity.Figure;
import by.epam.task1a.entity.Plane;
import by.epam.task1a.factory.FigureFactory;
import by.epam.task1a.factory.PlaneFactory;
import by.epam.task1a.factory.PointBuilder;
import by.epam.task1a.parser.SourceParser;
import by.epam.task1a.reader.SourceReader;
import by.epam.task1b.repository.comparator.CompareByAngleToXYPlane;
import by.epam.task1b.repository.comparator.CompareById;
import by.epam.task1b.repository.comparator.CompareByPointACoordinateX;
import by.epam.task1b.repository.specification.*;
import by.epam.task1b.repository.storage.FigureStorage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collections;

public class FigureRepositoryTest {
    private static final String CORRECT_DATA_SOURCE = "/Users/ivanstrazhevich/Desktop/IdeaProjects/webDev/data/test1BData.txt";
    private static final String CORRECT_POINT_LINE = "4.0 10.0 17.0";
    private static final int FIRST_ELEMENT = 0;
    private static final double ANGLE_TO_FILTER = 50.0;
    private SourceReader sourceReader;
    private SourceParser sourceParser;
    private FigureFactory planeFactory;
    private FigureRepository planeRepository;
    private ArrayList<Plane> planes;

    @BeforeMethod
    public void setUp() throws Exception {
        sourceReader = new SourceReader();
        sourceParser = new SourceParser();
        planeFactory = PlaneFactory.getInstance();
        ArrayList<String> planeDataList = sourceReader.readSource(CORRECT_DATA_SOURCE);
        planeDataList = sourceParser.excludeWrongLineAtPlaneCoordinatesDataFromList(planeDataList);
        planes = planeFactory.createFigures(planeDataList);
        planeRepository = new FigureRepository();
    }

    @AfterMethod
    public void tearDown() {
        sourceReader = null;
        sourceParser = null;
        planeFactory = null;
        planes = null;
        planeRepository = null;
    }

    @Test
    public void testAddEqualsItem() {
        Plane plane = planes.get(FIRST_ELEMENT);
        planeRepository.add(plane);
        Assert.assertEquals(planeRepository.query(new SelectAllDefaultSortedByAngleToXYCoordinatesPlaneQuery(new CompareById())).get(FIRST_ELEMENT),
                plane);
        planeRepository.remove(plane);
    }

    @Test(dependsOnMethods = {"testAddEqualsItem"}, alwaysRun = true)
    public void testRemoveTrue() {
        Plane plane = planes.get(FIRST_ELEMENT);
        planeRepository.remove(plane);
        Assert.assertTrue(planeRepository.query(new SelectAllDefaultSortedByAngleToXYCoordinatesPlaneQuery(new CompareById())).isEmpty());
    }

    @Test(dependsOnMethods = {"testAddEqualsItem", "testRemoveTrue"}, alwaysRun = true)
    public void testUpdate() throws Exception {
        Plane plane = planes.get(FIRST_ELEMENT);
        plane.setA(PointBuilder.getInstance().createPoint(CORRECT_POINT_LINE));
        planeRepository.update(plane);
        Assert.assertEquals(planeRepository.query(new SelectAllDefaultSortedByAngleToXYCoordinatesPlaneQuery(new CompareById())).get(FIRST_ELEMENT),
                plane);
        planeRepository.remove(plane);

    }

    @Test(dependsOnMethods = {"testAddEqualsItem", "testRemoveTrue", "testUpdate"}, alwaysRun = true)
    public void testAddAll() {
        planeRepository.addAll(planes);
        Assert.assertEquals(FigureStorage.getInstance().getFigureList(), planes);
    }

    @Test(dependsOnMethods = {"testAddAll", "testAddEqualsItem", "testRemoveTrue", "testUpdate"}, alwaysRun = true)
    public void testQuerySelectAllById() {
        FigureStorage figureStorage = FigureStorage.getInstance();
        ArrayList<Figure> expected = new ArrayList<>();
        expected.addAll(figureStorage.getFigureList());
        Collections.sort(expected, new CompareById());
        ArrayList<Figure> actual = planeRepository.query(new SelectAllDefaultSortedByIdQuery());
        Assert.assertEquals(actual, expected);
    }

    @Test(dependsOnMethods = {"testAddAll", "testAddEqualsItem", "testRemoveTrue", "testUpdate"}, alwaysRun = true)
    public void testQuerySelectAllByPointACoordinateX() {
        FigureStorage figureStorage = FigureStorage.getInstance();
        ArrayList<Figure> expected = new ArrayList<>();
        expected.addAll(figureStorage.getFigureList());
        Collections.sort(expected, new CompareByPointACoordinateX());
        ArrayList<Figure> actual = planeRepository.query(new SelectAllDefaultSortedByPointACoordineteX());
        Assert.assertEquals(actual, expected);
    }

    @Test(dependsOnMethods = {"testAddAll", "testAddEqualsItem", "testRemoveTrue", "testUpdate"}, alwaysRun = true)
    public void testQuerySelectPlanesWithAngleToXYLessThen() {
        FigureStorage figureStorage = FigureStorage.getInstance();
        ArrayList<Figure> expected = new ArrayList<>();
        expected.addAll(figureStorage.getFigureList());
        Collections.sort(expected, new CompareById());
        ArrayList<Figure> actual = planeRepository.query(new SelectPlanesWithAngleToXYPlaneLessThen(ANGLE_TO_FILTER));
        Assert.assertNotEquals(actual.size(), expected.size());
    }

    @Test(dependsOnMethods = {"testAddAll", "testAddEqualsItem", "testRemoveTrue", "testUpdate"}, alwaysRun = true)
    public void testQuerySelectPlanesWithAngleToXZLessThen() {
        FigureStorage figureStorage = FigureStorage.getInstance();
        ArrayList<Figure> expected = new ArrayList<>();
        expected.addAll(figureStorage.getFigureList());
        Collections.sort(expected, new CompareById());
        ArrayList<Figure> actual = planeRepository.query(new SelectPlanesWithAngleToXZPlaneLessThen(ANGLE_TO_FILTER));
        Assert.assertNotEquals(actual.size(), expected.size());
    }

    @Test(dependsOnMethods = {"testAddAll", "testAddEqualsItem", "testRemoveTrue", "testUpdate"}, alwaysRun = true)
    public void testQuerySelectPlanesWithAngleToYZLessThen() {
        FigureStorage figureStorage = FigureStorage.getInstance();
        ArrayList<Figure> expected = new ArrayList<>();
        expected.addAll(figureStorage.getFigureList());
        Collections.sort(expected, new CompareById());
        ArrayList<Figure> actual = planeRepository.query(new SelectPlanesWithAngleToYZPlaneLessThen(ANGLE_TO_FILTER));
        Assert.assertNotEquals(actual.size(), expected.size());
    }

    @Test(dependsOnMethods = {"testAddAll", "testAddEqualsItem", "testRemoveTrue", "testUpdate"}, alwaysRun = true)
    public void testQuerySelectAllByAngleToXYCoordinatePlane() {
        FigureStorage figureStorage = FigureStorage.getInstance();
        ArrayList<Figure> expected = new ArrayList<>();
        expected.addAll(figureStorage.getFigureList());
        Collections.sort(expected, new CompareByAngleToXYPlane());
        ArrayList<Figure> actual = planeRepository.query(new SelectAllDefaultSortedByAngleToXYCoordinatesPlaneQuery());
        Assert.assertEquals(actual,expected);
    }
}