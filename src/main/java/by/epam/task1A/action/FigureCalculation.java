package by.epam.task1A.action;

import by.epam.task1A.entity.Plane;
import by.epam.task1A.entity.Point;
import by.epam.task1A.entity.VectorByPoints;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FigureCalculation implements Planeable {
    static Logger logger = LogManager.getLogger();

    public double countAngleToAxisPlane(Plane plane) {
        Point pointA = plane.getA();
        Point pointB = plane.getB();
        Point pointC = plane.getC();
        VectorByPoints vectorAB = new VectorByPoints(pointA, pointB);
        VectorByPoints vectorAC = new VectorByPoints(pointA, pointC);


        return 0;

    }

    public boolean checkIfThreeDotsIsPlane(Point pointA, Point pointB, Point pointC) {
        VectorByPoints vectorAB = new VectorByPoints(pointA, pointB);
        VectorByPoints vectorAC = new VectorByPoints(pointA, pointC);

        return (!pointA.equals(pointB) && !pointB.equals(pointC) && !pointC.equals(pointA))
                && (vectorAB.getX() / vectorAC.getX() != vectorAB.getY() / vectorAC.getY()
                || vectorAB.getX() / vectorAC.getX() != vectorAB.getZ() / vectorAC.getZ()
                || vectorAB.getY() / vectorAC.getY() != vectorAB.getZ() / vectorAC.getZ());

    }

    public boolean checkIfPlanePerpendicularDatumLine(Plane plane) {
        return (plane.getA().getX() == plane.getB().getX() && plane.getB().getX() == plane.getC().getX())
                || (plane.getA().getY() == plane.getB().getY() && plane.getB().getY() == plane.getC().getY())
                || (plane.getA().getZ() == plane.getB().getZ() && plane.getB().getZ() == plane.getC().getZ());

    }
}
