package by.epam.task1b.registrator;

import java.util.HashMap;

public class PlaneDataRegistrar<T> {
    private HashMap<Long, Double> figureAngleXYHashMap = new HashMap<>();
    private HashMap<Long, Double> figureAngleXZHashMap = new HashMap<>();
    private HashMap<Long, Double> figureAngleYZHashMap = new HashMap<>();
    private static PlaneDataRegistrar<HashMap> instance;

    private PlaneDataRegistrar() {
    }

    public static final PlaneDataRegistrar<HashMap> getInstance() {
        if (instance == null) {
            instance = new PlaneDataRegistrar();
        }
        return instance;
    }

    public HashMap<Long, Double> getFigureAngleXYHashMap() {
        return figureAngleXYHashMap;
    }

    public HashMap<Long, Double> getFigureAngleXZHashMap() {
        return figureAngleXZHashMap;
    }

    public HashMap<Long, Double> getFigureAngleYZHashMap() {
        return figureAngleYZHashMap;
    }
}
