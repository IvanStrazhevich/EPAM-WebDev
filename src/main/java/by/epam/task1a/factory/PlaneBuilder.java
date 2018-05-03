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


public class PlaneBuilder implements FigureBuildable {
    static Logger logger = LogManager.getLogger();
    private PointBuildable pointBuilder;
    private SourceParsable sourceParser;
    private SourceValidatable sourceValidator;
    private static final int POINT_A = 0;
    private static final int POINT_B = 1;
    private static final int POINT_C = 2;

    private PlaneBuilder(PointBuildable pointBuilder, SourceParsable sourceParser, SourceValidatable sourceValidator) {
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
            ArrayList<String> pointDataList = sourceParser.createDotListFromString(dataSource);
            logger.debug(pointDataList + " Data for plane");
            String pointA = pointDataList.get(POINT_A);
            String pointB = pointDataList.get(POINT_B);
            String pointC = pointDataList.get(POINT_C);
            Plane plane = new Plane(pointBuilder.createPoint(pointA),
                    pointBuilder.createPoint(pointB),
                    pointBuilder.createPoint(pointC));
            logger.debug(plane.toString());
            return plane;
        } else {
            throw new ExtendedException(" Incorrect data");
        }
    }

    public void setPointBuildable(PointBuildable pointBuilder) {
        this.pointBuilder = pointBuilder;
    }

    public void setSourceParser(SourceParsable sourceParser) {
        this.sourceParser = sourceParser;
    }

    public void setSourceValidator(SourceValidatable sourceValidator) {
        this.sourceValidator = sourceValidator;
    }
}
