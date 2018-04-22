package by.epam.ivanStrazhevich.task.factory;

import by.epam.ivanStrazhevich.task.entity.Plane;
import by.epam.ivanStrazhevich.task.entity.Point;
import by.epam.ivanStrazhevich.task.sourceParser.SourceParsable;
import by.epam.ivanStrazhevich.task.sourceParser.SourceParserFromList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class PlaneFactory implements FigureFactory {
    Logger logger = LogManager.getLogger();
    FigureFactory pointFactory;
    SourceParsable sourceParser;

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
    public Plane createFigure(String dataSource) {
        sourceParser = new SourceParserFromList();
        ArrayList<String> dataSourceList = new ArrayList<>();
        dataSourceList.add(dataSource);
        ArrayList<String> dotDataList = sourceParser.createDotData(dataSourceList);
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
    }
}
