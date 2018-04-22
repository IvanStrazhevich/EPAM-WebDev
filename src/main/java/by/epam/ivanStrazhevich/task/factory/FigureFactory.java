package by.epam.ivanStrazhevich.task.factory;

import by.epam.ivanStrazhevich.task.entity.Figure;
import by.epam.ivanStrazhevich.task.exception.ExtendedException;

public interface FigureFactory {
    Figure createFigure(String dataSourse) throws ExtendedException;
}
