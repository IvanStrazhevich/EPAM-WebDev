package by.epam.task1b.registrar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;


public class PlaneDataRegistrar<T> {
static Logger logger = LogManager.getLogger();
    private HashMap<Long, Double> figureAngleXYHashMap;
    private HashMap<Long, Double> figureAngleXZHashMap;
    private HashMap<Long, Double> figureAngleYZHashMap;
    private static PlaneDataRegistrar<HashMap> instance;

    private PlaneDataRegistrar() {
        figureAngleXYHashMap = new HashMap<>();
        figureAngleXZHashMap = new HashMap<>();
        figureAngleYZHashMap = new HashMap<>();
    }

    public static final PlaneDataRegistrar<HashMap> getInstance() {
        if (instance == null) {
            instance = new PlaneDataRegistrar();

        }
        return instance;
    }

    public HashMap<Long, Double> getFigureAngleXYHashMap() {
        logger.debug(figureAngleXYHashMap);
        return figureAngleXYHashMap;
    }

    public HashMap<Long, Double> getFigureAngleXZHashMap() {

        logger.debug(figureAngleXZHashMap);
        return figureAngleXZHashMap;
    }

    public HashMap<Long, Double> getFigureAngleYZHashMap() {
        logger.debug(figureAngleYZHashMap);
        return figureAngleYZHashMap;
    }

}
