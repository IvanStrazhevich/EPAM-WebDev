package by.epam.task1b.registrar;

import by.epam.task1a.action.FigureCalculation;
import by.epam.task1a.entity.Plane;
import by.epam.task1a.factory.FigureFactory;
import by.epam.task1a.factory.PlaneFactory;
import by.epam.task1a.factory.PointBuilder;
import by.epam.task1a.parser.SourceParser;
import by.epam.task1a.reader.SourceReader;
import by.epam.task1b.repository.FigureRepository;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class PlaneDataUpdaterTest {
    private static final String CORRECT_DATA_SOURCE = "/Users/ivanstrazhevich/Desktop/IdeaProjects/webDev/data/test1BData.txt";
    private static final String CORRECT_POINT_LINE = "4.0 10.0 17.0";
    private static final int FIRST_ELEMENT = 0;
    private SourceReader sourceReader;
    private SourceParser sourceParser;
    private FigureFactory planeFactory;
    private FigureRepository planeRepository;
    private PlaneObserver<Plane> planeObserver;
    private ArrayList<Plane> planes;
    private PlaneDataRegistrar planeDataRegistrar;
    private FigureCalculation figureCalculation;

    @BeforeMethod
    public void setUp() throws Exception {
        sourceReader = new SourceReader();
        sourceParser = new SourceParser();
        planeFactory = PlaneFactory.getInstance();
        ArrayList<String> planeDataList = sourceReader.readSource(CORRECT_DATA_SOURCE);
        planeDataList = sourceParser.excludeWrongLineAtPlaneCoordinatesDataFromList(planeDataList);
        planes = planeFactory.createFigures(planeDataList);
        figureCalculation = new FigureCalculation();
        planeRepository = new FigureRepository();
        planeObserver = PlaneObserver.getInstance();
        planeDataRegistrar = PlaneDataRegistrar.getInstance();

    }

    @AfterMethod
    public void tearDown() {
        sourceReader = null;
        sourceParser = null;
        planeFactory = null;
        planes = null;
        planeRepository = null;
        planeObserver = null;
        planeDataRegistrar = null;
    }

    @Test
    public void testUpdateEqualsResult() throws Exception {
        Plane plane = planes.get(FIRST_ELEMENT);
        plane.attach(planeObserver);
        planeRepository.add(plane);
        plane.setA(PointBuilder.getInstance().createFigure(CORRECT_POINT_LINE));
        planeRepository.update(plane);
        double expected = figureCalculation.countAngleToXYPlaneGrad(plane);
        double actual = (Double)planeDataRegistrar.getFigureAngleXYHashMap().get(plane.getId());
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testUpdateDifferentDataBeforeAndAfterUpdate() throws Exception {
        Plane plane = planes.get(FIRST_ELEMENT);
        System.out.println(plane);
        System.out.println(planeObserver);
        plane.attach(planeObserver);
        planeRepository.add(plane);
        double previous = figureCalculation.countAngleToXYPlaneGrad(plane);
        plane.setA(PointBuilder.getInstance().createFigure(CORRECT_POINT_LINE));
        planeRepository.update(plane);
        double actual = (Double)planeDataRegistrar.getFigureAngleXYHashMap().get(plane.getId());
        Assert.assertNotEquals(actual,previous);
    }
}