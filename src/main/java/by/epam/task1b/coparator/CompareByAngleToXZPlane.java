package by.epam.task1b.coparator;

import by.epam.task1a.entity.Figure;
import by.epam.task1b.registrar.PlaneDataRegistrar;

import java.util.Comparator;
import java.util.HashMap;

public class CompareByAngleToXZPlane implements Comparator<Figure> {
    @Override
    public int compare(Figure o1, Figure o2) {
        HashMap<Long, Double> planeDataMap = PlaneDataRegistrar.getInstance().getFigureAngleXZHashMap();
        return Double.compare(planeDataMap.get(o1.getId()), planeDataMap.get(o2.getId()));
    }
}

