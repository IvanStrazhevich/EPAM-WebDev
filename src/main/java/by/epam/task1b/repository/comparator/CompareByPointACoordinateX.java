package by.epam.task1b.repository.comparator;

import by.epam.task1a.entity.Plane;

import java.util.Comparator;


public class CompareByPointACoordinateX<T> implements Comparator<Plane> {
    @Override
    public int compare(Plane o1, Plane o2) {

        return Double.compare(o1.getA().getX(), o2.getA().getX());
    }
}