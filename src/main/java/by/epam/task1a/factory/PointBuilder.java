package by.epam.task1a.factory;

import by.epam.task1a.entity.Point;
import by.epam.task1a.exception.ExtendedException;
import by.epam.task1a.validator.SourceValidatable;
import by.epam.task1a.validator.SourceValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class PointBuilder implements FigureBuilder {
    static Logger logger = LogManager.getLogger();
    private static final int POINT_A = 0;
    private static final int POINT_B = 1;
    private static final int POINT_C = 2;
    private SourceValidatable sourceValidator;


    private PointBuilder(SourceValidatable sourceValidator) {
        this.sourceValidator = sourceValidator;
    }

    private static PointBuilder instance;

    public static PointBuilder getInstance() {
        if (null == instance) {
            instance = new PointBuilder(new SourceValidator());
        }
        return instance;
    }

    @Override
    public Point createFigure(String dataSource) throws ExtendedException {
        if (dataSource != null && sourceValidator.validateDataForPoint(dataSource)) {
            String[] arrayData = dataSource.split("\\s");
            logger.debug(Arrays.toString(arrayData));
            Point point = new Point(Double.parseDouble(arrayData[POINT_A]),
                    Double.parseDouble(arrayData[POINT_B]),
                    Double.parseDouble(arrayData[POINT_C]));
            logger.debug(point.toString());
            return point;
        } else {
            throw new ExtendedException("Incorrect data");
        }
    }

    public void setSourceValidator(SourceValidatable sourceValidator) {
        this.sourceValidator = sourceValidator;
    }
}
