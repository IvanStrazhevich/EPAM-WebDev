package by.epam.ivanStrazhevich.task.factory;

import by.epam.ivanStrazhevich.task.entity.Figure;

public interface FigureFactory {
    Figure createFigure(String dataSourse);
}
