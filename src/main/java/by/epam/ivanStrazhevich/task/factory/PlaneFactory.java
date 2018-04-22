package by.epam.ivanStrazhevich.task.factory;

import by.epam.ivanStrazhevich.task.entity.Figure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class PlaneFactory implements FigureFactory{
    Logger logger = LogManager.getLogger();
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
    public Figure createFigure(String dataSourse) {
        return null;
    }
}
