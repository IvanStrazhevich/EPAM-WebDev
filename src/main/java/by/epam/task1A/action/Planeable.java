package by.epam.task1A.action;

import by.epam.task1A.entity.Plane;
import by.epam.task1A.entity.Point;


public interface Planeable {
    double countAngleToAxisPlane(Plane plane);
    boolean checkIfThreeDotsIsPlane(Point A, Point B, Point C);
    boolean checkIfPlanePerpendicularDatumLine(Plane plane);
}
