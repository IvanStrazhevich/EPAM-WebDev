package by.epam.task1A.action;

import by.epam.task1A.entity.Plane;
import by.epam.task1A.entity.Point;


public interface Planeable {
    double countAngleToAxisPlaneGrad(Plane plane, Plane axisPlane);
    boolean checkIfThreeDotsIsPlane(Point A, Point B, Point C);
    boolean checkIfPlanePerpendicularDatumLine(Plane plane);
}
