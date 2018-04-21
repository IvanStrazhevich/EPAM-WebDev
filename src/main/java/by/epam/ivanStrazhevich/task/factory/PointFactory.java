package by.epam.ivanStrazhevich.task.factory;

import by.epam.ivanStrazhevich.task.entity.Figure;

public class PointFactory implements FigureFactory{
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
    public Figure createFigure(String figureData) {
        return null;
    }
}
