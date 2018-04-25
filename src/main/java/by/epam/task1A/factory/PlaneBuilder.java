package by.epam.task1A.factory;

import by.epam.task1A.entity.Plane;
import by.epam.task1A.entity.Point;
import by.epam.task1A.exception.ExtendedException;
import by.epam.task1A.parser.SourceParsable;
import by.epam.task1A.parser.SourceParser;
import by.epam.task1A.validator.SourceValidatable;
import by.epam.task1A.validator.SourceValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class PlaneBuilder implements FigureBuilder {
    static Logger logger = LogManager.getLogger();
    private FigureBuilder pointBuilder;
    private SourceParsable sourceParser;
    private SourceValidatable sourceValidator;

    private PlaneBuilder(FigureBuilder pointBuilder, SourceParsable sourceParser, SourceValidatable sourceValidator) {
        this.pointBuilder = pointBuilder;
        this.sourceParser = sourceParser;
        this.sourceValidator = sourceValidator;
    }

    private static PlaneBuilder instance;

    public static PlaneBuilder getInstance() {
        if (null == instance) {
            instance = new PlaneBuilder(PointBuilder.getInstance(), new SourceParser(), new SourceValidator());
        }
        return instance;
    }

    @Override
    public Plane createFigure(String dataSource) throws ExtendedException {
        if (dataSource != null && sourceValidator.validateCorrectLinePointsForPlane(dataSource)) {
            ArrayList<String> dotDataList = sourceParser.createDotListFromString(dataSource);
            logger.debug(dotDataList + " Data for plane");
            String pointA = dotDataList.get(0);
            String pointB = dotDataList.get(1);
            String pointC = dotDataList.get(2);
            Plane plane = new Plane((Point) pointBuilder.createFigure(pointA),
                    (Point) pointBuilder.createFigure(pointB),
                    (Point) pointBuilder.createFigure(pointC));
            logger.debug(plane.toString());
            return plane;
        } else {
            throw new ExtendedException("Incorrect data");
        }
    }

    public void setPointBuilder(FigureBuilder pointBuilder) {
        this.pointBuilder = pointBuilder;
    }

    public void setSourceParser(SourceParsable sourceParser) {
        this.sourceParser = sourceParser;
    }

    public void setSourceValidator(SourceValidatable sourceValidator) {
        this.sourceValidator = sourceValidator;
    }
}
