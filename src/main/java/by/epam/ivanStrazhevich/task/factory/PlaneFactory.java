package by.epam.ivanStrazhevich.task.factory;

import by.epam.ivanStrazhevich.task.entity.Figure;

public class PlaneFactory implements FigureFactory{
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
    public Figure createFigure(String figureData) {
        return null;
    }
}
