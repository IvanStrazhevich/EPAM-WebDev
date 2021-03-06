package by.epam.task1a.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VectorByPoints extends Figure {
    static Logger logger = LogManager.getLogger();
    private double x;
    private double y;
    private double z;

    public VectorByPoints(Point pointA, Point pointB) {
        super();
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
        return (Double.compare(vector.z, z) != 0);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
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
                ", x = " + x +
                ", y = " + y +
                ", z = " + z +
                " }";
    }
}
