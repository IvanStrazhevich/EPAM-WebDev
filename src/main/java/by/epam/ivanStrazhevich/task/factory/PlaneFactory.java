package by.epam.ivanStrazhevich.task.factory;

import by.epam.ivanStrazhevich.task.entity.Plane;
import by.epam.ivanStrazhevich.task.entity.Point;
import by.epam.ivanStrazhevich.task.exception.ExtendedException;
import by.epam.ivanStrazhevich.task.sourceParser.SourceParsable;
import by.epam.ivanStrazhevich.task.sourceParser.SourceParserFromList;
import by.epam.ivanStrazhevich.task.validator.SourceValidatable;
import by.epam.ivanStrazhevich.task.validator.SourceValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class PlaneFactory implements FigureFactory {
    Logger logger = LogManager.getLogger();
    FigureFactory pointFactory;
    SourceParsable sourceParser;
    SourceValidatable sourceValidator;

    private PlaneFactory() {
    }

    private static PlaneFactory instance;

    public static PlaneFactory getInstance() {
        if (null == instance) {
            instance = new PlaneFactory();
        }
        return instance;
    }

    @Override
    public Plane createFigure(String dataSource) throws ExtendedException {
        sourceValidator = new SourceValidator();
        if (dataSource != null && sourceValidator.validateCorrectLinePointsForPlane(dataSource)) {
            sourceParser = new SourceParserFromList();
            ArrayList<String> dotDataList = sourceParser.createDotDataFromString(dataSource);
            pointFactory = PointFactory.getInstance();
            logger.debug(dotDataList + " Data for plane");
            String pointA = dotDataList.get(0);
            String pointB = dotDataList.get(1);
            String pointC = dotDataList.get(2);
            Plane plane = new Plane((Point) pointFactory.createFigure(pointA),
                    (Point) pointFactory.createFigure(pointB),
                    (Point) pointFactory.createFigure(pointC));
            logger.debug(plane.toString());
            return plane;
        } else {
            throw new ExtendedException("Incorrect data");
        }
    }
}
