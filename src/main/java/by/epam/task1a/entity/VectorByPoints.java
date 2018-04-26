package by.epam.task1a.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VectorByPoints extends Figure {
    static Logger logger = LogManager.getLogger();
    private Point pointA;
    private Point pointB;
    private double x;
    private double y;
    private double z;

    public VectorByPoints(Point pointA, Point pointB) {
        super();
        this.pointA = pointA;
        this.pointB = pointB;
        this.x = pointA.getX() - pointB.getX();
        this.y = pointA.getY() - pointB.getY();
        this.z = pointA.getZ() - pointB.getZ();
    }

    public VectorByPoints() {
        super();
    }

    @Override
    public void identifyFigure() {
        logger.info("Vector is done");
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        VectorByPoints vector = (VectorByPoints) o;

        if (Double.compare(vector.x, x) != 0) return false;
        if (Double.compare(vector.y, y) != 0) return false;
        if (Double.compare(vector.z, z) != 0) return false;
        if (pointA != null ? !pointA.equals(vector.pointA) : vector.pointA != null) return false;
        return pointB != null ? pointB.equals(vector.pointB) : vector.pointB == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (pointA != null ? pointA.hashCode() : 0);
        result = 31 * result + (pointB != null ? pointB.hashCode() : 0);
        temp = Double.doubleToLongBits(x);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "VectorByPoints { " +
                "pointA = " + pointA +
                ", pointB = " + pointB +
                ", x = " + x +
                ", y = " + y +
                ", z = " + z +
                " }";
    }
}
