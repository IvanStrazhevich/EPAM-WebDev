package by.epam.task.action;

import by.epam.task.entity.Plane;
import by.epam.task.entity.Point;


public interface Planeable {
    double countAngleToAxisPlane(Plane plane);
    boolean checkIfThreeDotsIsPlane(Point A, Point B, Point C);
    boolean checkIfPlanePerpendicularDatumLine(Plane plane);
}
