package by.epam.task1a.action;

import by.epam.task1a.entity.Plane;
import by.epam.task1a.entity.Point;

public interface Calculatable {
    double countAngleToXYPlaneGrad(Plane plane);

    double countAngleToYZPlaneGrad(Plane plane);

    double countAngleToXZPlaneGrad(Plane plane);

    boolean checkIfThreeDotsIsPlane(Point A, Point B, Point C);

    boolean checkIfPlanePerpendicularDatumLine(Plane plane);
}
