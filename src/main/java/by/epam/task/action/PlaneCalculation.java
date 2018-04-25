package by.epam.task.action;

import by.epam.task.entity.Plane;
import by.epam.task.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlaneCalculation implements Planeable {
    static Logger logger = LogManager.getLogger();

    public double countAngleToAxisPlane(Plane plane) {
        Point A =plane.getA();
        Point B =plane.getB();
        Point C =plane.getC();
        double ABx = A.getX() - B.getX();
        double ABy = A.getY() - B.getY();
        double ABz = A.getZ() - B.getZ();
        double ACx = A.getX() - C.getX();
        double ACy = A.getY() - C.getY();
        double ACz = A.getZ() - C.getZ();

        return 0;

    }

    public boolean checkIfThreeDotsIsPlane(Point A, Point B, Point C) {
        double ABx = A.getX() - B.getX();
        double ABy = A.getY() - B.getY();
        double ABz = A.getZ() - B.getZ();
        double ACx = A.getX() - C.getX();
        double ACy = A.getY() - C.getY();
        double ACz = A.getZ() - C.getZ();

        return !A.equals(B) && !B.equals(C) && !C.equals(A) &&
                (ABx / ACx != ABy / ACy || ABx / ACx != ABz / ACz || ABy / ACy != ABz / ACz);

    }

    public boolean checkIfPlanePerpendicularDatumLine(Plane plane) {
        return (plane.getA().getX() == plane.getB().getX() && plane.getB().getX() == plane.getC().getX()) ||
                (plane.getA().getY() == plane.getB().getY() && plane.getB().getY() == plane.getC().getY()) ||
                (plane.getA().getZ() == plane.getB().getZ() && plane.getB().getZ() == plane.getC().getZ());

    }
}
