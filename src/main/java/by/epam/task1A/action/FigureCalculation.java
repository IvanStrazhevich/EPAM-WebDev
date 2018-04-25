package by.epam.task1A.action;

import by.epam.task1A.entity.Plane;
import by.epam.task1A.entity.Point;
import by.epam.task1A.entity.VectorByPoints;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FigureCalculation implements Planeable {
    static Logger logger = LogManager.getLogger();

    private VectorByPoints countTheOneNormalVector(VectorByPoints planeVectorN) {
        VectorByPoints theOneNormalVector = new VectorByPoints();
        theOneNormalVector.setX(planeVectorN.getX() / (Math.sqrt(Math.pow(planeVectorN.getX(), 2.0) +
                Math.pow(planeVectorN.getY(), 2.0) + Math.pow(planeVectorN.getZ(), 2.0))));

        theOneNormalVector.setY(planeVectorN.getY() / (Math.sqrt(Math.pow(planeVectorN.getX(), 2.0) +
                Math.pow(planeVectorN.getY(), 2.0) + Math.pow(planeVectorN.getZ(), 2.0))));

        theOneNormalVector.setZ(planeVectorN.getZ() / (Math.sqrt(Math.pow(planeVectorN.getX(), 2.0) +
                Math.pow(planeVectorN.getY(), 2.0) + Math.pow(planeVectorN.getZ(), 2.0))));

        logger.debug(theOneNormalVector + "The one normalVector");
        return theOneNormalVector;
    }

    private VectorByPoints countNormalVectorForPlane(Plane plane) {
        Point pointA = plane.getA();
        Point pointB = plane.getB();
        Point pointC = plane.getC();
        //plane vector multiplication calculations
        VectorByPoints planeVectorN = new VectorByPoints();
        planeVectorN.setX(pointA.getY() * (pointB.getZ() - pointC.getZ())
                + pointB.getY() * (pointC.getZ() - pointA.getZ())
                + pointC.getY() * (pointA.getZ() - pointB.getZ()));
        planeVectorN.setY(pointA.getZ() * (pointB.getX() - pointC.getX())
                + pointB.getZ() * (pointC.getX() - pointA.getX())
                + pointC.getZ() * (pointA.getX() - pointB.getX()));
        planeVectorN.setZ(pointA.getX() * (pointB.getY() - pointC.getY())
                + pointB.getX() * (pointC.getY() - pointA.getY())
                + pointC.getX() * (pointA.getY() - pointB.getY()));
        logger.debug(planeVectorN + " Normal Vector");

        return planeVectorN;

    }

    public double countAngleToAxisPlaneGrad(Plane plane, Plane axisPlane) {

        VectorByPoints normalVectorForPlane = countNormalVectorForPlane(plane);
        logger.debug(normalVectorForPlane + "normal to plane");
        VectorByPoints normalVectorForAxisPlane = countNormalVectorForPlane(axisPlane);
        logger.debug(normalVectorForAxisPlane + "normal to axis");
        double angleRad = Math.acos(Math.abs(normalVectorForPlane.getX() * normalVectorForAxisPlane.getX()
                + normalVectorForPlane.getY() * normalVectorForAxisPlane.getY()
                + normalVectorForPlane.getZ() * normalVectorForAxisPlane.getZ())
                / (Math.sqrt(Math.pow(normalVectorForPlane.getX(), 2.0)
                + Math.pow(normalVectorForPlane.getY(), 2.0)
                + Math.pow(normalVectorForPlane.getZ(), 2.0))
                * Math.sqrt(Math.pow(normalVectorForAxisPlane.getX(), 2.0)
                + Math.pow(normalVectorForAxisPlane.getY(), 2.0)
                + Math.pow(normalVectorForAxisPlane.getZ(), 2.0))));
        double angleDegrees = Math.toDegrees(angleRad);
        logger.debug(angleRad + "Angle Rad" );
        logger.debug(angleDegrees + "Angle Degrees" );
        return angleDegrees;
    }

    public boolean checkIfThreeDotsIsPlane(Point pointA, Point pointB, Point pointC) {
        // vectors calculations
        VectorByPoints vectorAB = new VectorByPoints(pointA, pointB);
        VectorByPoints vectorAC = new VectorByPoints(pointA, pointC);

        return (!pointA.equals(pointB) && !pointB.equals(pointC) && !pointC.equals(pointA)) // check if point different
                && (vectorAB.getX() / vectorAC.getX() != vectorAB.getY() / vectorAC.getY()  // vector collinearity calculation
                || vectorAB.getX() / vectorAC.getX() != vectorAB.getZ() / vectorAC.getZ()
                || vectorAB.getY() / vectorAC.getY() != vectorAB.getZ() / vectorAC.getZ());

    }

    public boolean checkIfPlanePerpendicularDatumLine(Plane plane) {
        return (plane.getA().getX() == plane.getB().getX() && plane.getB().getX() == plane.getC().getX())
                || (plane.getA().getY() == plane.getB().getY() && plane.getB().getY() == plane.getC().getY())
                || (plane.getA().getZ() == plane.getB().getZ() && plane.getB().getZ() == plane.getC().getZ());

    }
}
