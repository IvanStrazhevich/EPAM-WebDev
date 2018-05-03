package by.epam.task1a.factory;

import by.epam.task1a.entity.Plane;
import by.epam.task1a.exception.ExtendedException;
import by.epam.task1a.parser.SourceParsable;
import by.epam.task1a.parser.SourceParser;
import by.epam.task1a.validator.SourceValidatable;
import by.epam.task1a.validator.SourceValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class PlaneBuilder implements FigureBuilder {
    static Logger logger = LogManager.getLogger();
    private PointBuilder pointBuilder;
    private SourceParsable sourceParser;
    private SourceValidatable sourceValidator;

    private PlaneBuilder(PointBuilder pointBuilder, SourceParsable sourceParser, SourceValidatable sourceValidator) {
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
            Plane plane = new Plane(pointBuilder.createFigure(pointA),
                    pointBuilder.createFigure(pointB),
                    pointBuilder.createFigure(pointC));
            logger.debug(plane.toString());
            return plane;
        } else {
            throw new ExtendedException(" Incorrect data");
        }
    }

    public void setPointBuilder(PointBuilder pointBuilder) {
        this.pointBuilder = pointBuilder;
    }

    public void setSourceParser(SourceParsable sourceParser) {
        this.sourceParser = sourceParser;
    }

    public void setSourceValidator(SourceValidatable sourceValidator) {
        this.sourceValidator = sourceValidator;
    }
}
