package by.epam.task1b.repository;


import java.util.HashMap;

public class FigureDataStorage{
    private HashMap<Long, Double> figureAngleXYHashMap;
    private HashMap<Long, Double> figureAngleXZHashMap;
    private HashMap<Long, Double> figureAngleYZHashMap;
    private static FigureDataStorage instance;
    private FigureDataStorage() {
        this.figureAngleXYHashMap = new HashMap<>();
        this.figureAngleXZHashMap = new HashMap<>();
        this.figureAngleYZHashMap = new HashMap<>();
    }

    public static final FigureDataStorage getInstance() {
        if (instance == null) {
            instance = new FigureDataStorage();
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
