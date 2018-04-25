package by.epam.task.factory;

import by.epam.task.entity.Figure;
import by.epam.task.exception.ExtendedException;

public interface FigureBuilder {
    Figure createFigure(String dataSourse) throws ExtendedException;
}
