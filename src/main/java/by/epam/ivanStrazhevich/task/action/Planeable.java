package by.epam.ivanStrazhevich.task.action;

import by.epam.ivanStrazhevich.task.entity.Plane;
import by.epam.ivanStrazhevich.task.entity.Point;


public interface Planeable {
    double countAngleToAxis(Plane plane);
    boolean checkIfThreeDotsIsPlane(Point A, Point B, Point C);
    boolean checkIfPlanePerpendicularDatumLine(Plane plane);
}
