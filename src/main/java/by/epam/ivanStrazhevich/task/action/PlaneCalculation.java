package by.epam.ivanStrazhevich.task.action;

import by.epam.ivanStrazhevich.task.entity.Plane;
import by.epam.ivanStrazhevich.task.entity.Point;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlaneCalculation implements Planeable {
    static Logger logger = LogManager.getLogger();

    public double countAngleToAxis(Plane plane) {
        return 0;

    }

    public boolean checkIfThreeDotsIsPlane(Point A, Point B, Point C) {

        return !A.equals(B) && !B.equals(C) && !C.equals(A);
    }

    public boolean checkIfPlanePerpendicularDatumLine(Plane plane) {
        return (plane.getA().getX() == plane.getB().getX() && plane.getB().getX() == plane.getC().getX()) ||
                (plane.getA().getY() == plane.getB().getY() && plane.getB().getY() == plane.getC().getY()) ||
                (plane.getA().getZ() == plane.getB().getZ() && plane.getB().getZ() == plane.getC().getZ());

    }
}
