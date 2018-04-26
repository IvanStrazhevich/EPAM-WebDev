package by.epam.task1a.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Point extends Figure {
    static Logger logger = LogManager.getLogger();
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
        notifyObservers();
    }

    public Point() {
        super();
    }

    @Override
    public void identifyFigure() {
        logger.info("Point is done");
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
        notifyObservers();
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
        notifyObservers();
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Point point = (Point) o;

        if (Double.compare(point.x, x) != 0) return false;
        if (Double.compare(point.y, y) != 0) return false;
        return Double.compare(point.z, z) == 0;
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
        return "Point { " +
                "x =" + x +
                ", y = " + y +
                ", z = " + z +
                " }";
    }
}
