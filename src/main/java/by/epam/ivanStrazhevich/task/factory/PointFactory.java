package by.epam.ivanStrazhevich.task.factory;

import by.epam.ivanStrazhevich.task.entity.Figure;
import by.epam.ivanStrazhevich.task.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class PointFactory implements FigureFactory{
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
    public Figure createFigure(String dataSourse) {

        return null;
    }
}
