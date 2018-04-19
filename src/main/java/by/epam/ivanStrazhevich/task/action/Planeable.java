package by.epam.ivanStrazhevich.task.action;

import by.epam.ivanStrazhevich.task.entity.Plane;


public interface Planeable {
    double countAngle(Plane plane);
    boolean checkIfPlane(Plane plane);
    boolean checkIfPlanePerpendicularDatumLine(Plane plane);
}
