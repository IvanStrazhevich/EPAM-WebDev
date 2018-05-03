package by.epam.task1a.factory;

import by.epam.task1a.entity.Figure;
import by.epam.task1a.exception.ExtendedException;

public interface FigureBuildable {
    Figure createFigure(String dataSource) throws ExtendedException;
}
