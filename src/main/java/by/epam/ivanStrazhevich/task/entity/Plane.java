package by.epam.ivanStrazhevich.task.entity;

public class Plane {
    private Point a;
    private Point b;
    private Point c;

    public Plane(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Plane() {
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plane plane = (Plane) o;

        if (a != null ? !a.equals(plane.a) : plane.a != null) return false;
        if (b != null ? !b.equals(plane.b) : plane.b != null) return false;
        return c != null ? c.equals(plane.c) : plane.c == null;
    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Plane { " +
                " a = " + a +
                ", b = " + b +
                ", c = " + c +
                " } ";
    }
}


