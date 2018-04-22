package by.epam.ivanStrazhevich.task.factory;

import by.epam.ivanStrazhevich.task.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class PointFactory implements FigureFactory {
    Logger logger = LogManager.getLogger();

    private PointFactory() {
    }

    private static PointFactory instance;

    public static PointFactory getInstance() {
        if (null == instance) {
            instance = new PointFactory();
        }
        return instance;
    }

    @Override
    public Point createFigure(String dataSource) {
        String[] arrayData = dataSource.split("\\s");
        logger.debug(Arrays.toString(arrayData));
        Point point = new Point(Double.parseDouble(arrayData[0]), Double.parseDouble(arrayData[1]), Double.parseDouble(arrayData[2]));
        logger.debug(point.toString());
        return point;
    }
}
