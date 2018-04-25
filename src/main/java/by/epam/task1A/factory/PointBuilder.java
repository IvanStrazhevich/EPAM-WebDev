package by.epam.task1A.factory;

import by.epam.task1A.entity.Point;
import by.epam.task1A.exception.ExtendedException;
import by.epam.task1A.validator.SourceValidatable;
import by.epam.task1A.validator.SourceValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class PointBuilder implements FigureBuilder {
    static Logger logger = LogManager.getLogger();
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
            Point point = new Point(Double.parseDouble(arrayData[0]),
                    Double.parseDouble(arrayData[1]),
                    Double.parseDouble(arrayData[2]));
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
