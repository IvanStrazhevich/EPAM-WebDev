package by.epam.task1a.factory;

import by.epam.task1a.entity.Point;
import by.epam.task1a.exception.ExtendedException;

public interface PointBuildable {
    Point createPoint(String dataSource) throws ExtendedException;
}
