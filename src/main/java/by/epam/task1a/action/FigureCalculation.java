package by.epam.task1a.action;

import by.epam.task1a.entity.Plane;
import by.epam.task1a.entity.Point;
import by.epam.task1a.entity.VectorByPoints;
import by.epam.task1a.exception.ExtendedException;
import by.epam.task1a.factory.PlaneBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FigureCalculation implements Calculatable {
    static Logger logger = LogManager.getLogger();
    private static final String XY_PLANE_COORDINATES = "1.0 1.0 0.0 2.0 1.0 0.0 1.0 2.0 0.0";
    private static final String YZ_PLANE_COORDINATES = "0.0 1.0 1.1 0.0 2.0 1.0 0.0 1.0 2.0";
    private static final String ZX_PLANE_COORDINATES = "1.0 0.0 1.1 2.0 0.0 1.0 1.0 0.0 2.0";
    private static final double POWER = 2.0;


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

    private double countPlanesAngleDegrees(Plane plane1, Plane plane2) {
        VectorByPoints normalVectorForPlane = countNormalVectorForPlane(plane1);
        logger.debug(normalVectorForPlane + "normal to plane");
        VectorByPoints normalVectorForAxisPlane = countNormalVectorForPlane(plane2);
        logger.debug(normalVectorForAxisPlane + "normal to axis");
        double angleRad = Math.acos(Math.abs(normalVectorForPlane.getX() * normalVectorForAxisPlane.getX()
                + normalVectorForPlane.getY() * normalVectorForAxisPlane.getY()
                + normalVectorForPlane.getZ() * normalVectorForAxisPlane.getZ())
                / (Math.sqrt(Math.pow(normalVectorForPlane.getX(), POWER)
                + Math.pow(normalVectorForPlane.getY(), POWER)
                + Math.pow(normalVectorForPlane.getZ(), POWER))
                * Math.sqrt(Math.pow(normalVectorForAxisPlane.getX(), POWER)
                + Math.pow(normalVectorForAxisPlane.getY(), POWER)
                + Math.pow(normalVectorForAxisPlane.getZ(), POWER))));
        double angleDegrees = Math.toDegrees(angleRad);
        logger.debug(angleRad + " Angle Rad");
        logger.debug(angleDegrees + " Angle Degrees");
        return angleDegrees;
    }

    @Override
    public double countAngleToXYPlaneGrad(Plane plane) {
        Plane planeXY = null;
        try {
            planeXY = PlaneBuilder.getInstance().createFigure(FigureCalculation.XY_PLANE_COORDINATES);
        } catch (ExtendedException e) {
            logger.error("Plane builder failed ", e);
        }
        return countPlanesAngleDegrees(plane, planeXY);
    }

    @Override
    public double countAngleToYZPlaneGrad(Plane plane) {
        Plane planeXZ = null;
        try {
            planeXZ = PlaneBuilder.getInstance().createFigure(FigureCalculation.ZX_PLANE_COORDINATES);
        } catch (ExtendedException e) {
            logger.error("Plane builder failed ", e);
        }
        return countPlanesAngleDegrees(plane, planeXZ);
    }

    @Override
    public double countAngleToXZPlaneGrad(Plane plane) {
        Plane planeYZ = null;
        try {
            planeYZ = PlaneBuilder.getInstance().createFigure(FigureCalculation.YZ_PLANE_COORDINATES);
        } catch (ExtendedException e) {
            logger.error("Plane builder failed ", e);
        }
        return countPlanesAngleDegrees(plane, planeYZ);
    }

    @Override
    public boolean checkIfThreeDotsIsPlane(Point pointA, Point pointB, Point pointC) {
        // vectors calculations
        VectorByPoints vectorAB = new VectorByPoints(pointA, pointB);
        VectorByPoints vectorAC = new VectorByPoints(pointA, pointC);

        return ((!(pointA.getX() == pointB.getX() && pointA.getY() == pointB.getY() && pointA.getZ() == pointB.getZ())
                && !(pointB.getX() == pointC.getX() & pointB.getY() == pointC.getY() & pointB.getZ() == pointC.getZ())
                && !(pointA.getX() == pointC.getX() & pointA.getY() == pointC.getY() & pointA.getZ() == pointC.getZ()))  // check if point different
                && (vectorAB.getX() / vectorAC.getX() != vectorAB.getY() / vectorAC.getY()  // vector collinearity calculation
                || vectorAB.getX() / vectorAC.getX() != vectorAB.getZ() / vectorAC.getZ()
                || vectorAB.getY() / vectorAC.getY() != vectorAB.getZ() / vectorAC.getZ()));
    }

    @Override
    public boolean checkIfPlanePerpendicularDatumLine(Plane plane) {
        return (plane.getA().getX() == plane.getB().getX() && plane.getB().getX() == plane.getC().getX())
                || (plane.getA().getY() == plane.getB().getY() && plane.getB().getY() == plane.getC().getY())
                || (plane.getA().getZ() == plane.getB().getZ() && plane.getB().getZ() == plane.getC().getZ());
    }
}
