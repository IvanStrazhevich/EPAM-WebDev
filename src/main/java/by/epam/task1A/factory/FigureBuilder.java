package by.epam.task1A.factory;

import by.epam.task1A.entity.Figure;
import by.epam.task1A.exception.ExtendedException;

public interface FigureBuilder {
    Figure createFigure(String dataSourse) throws ExtendedException;
}
