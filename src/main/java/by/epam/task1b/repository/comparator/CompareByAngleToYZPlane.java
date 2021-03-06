package by.epam.task1b.repository.comparator;

import by.epam.task1a.entity.Figure;
import by.epam.task1b.registrar.PlaneDataRegistrar;

import java.util.Comparator;
import java.util.HashMap;

public class CompareByAngleToYZPlane implements Comparator<Figure> {
    @Override
    public int compare(Figure o1, Figure o2) {
        HashMap<Long, Double> planeDataMap = PlaneDataRegistrar.getInstance().getFigureAngleXYHashMap();
        return Double.compare(planeDataMap.get(o1.getId()), planeDataMap.get(o2.getId()));
    }
}
