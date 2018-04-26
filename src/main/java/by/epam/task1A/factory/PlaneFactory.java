package by.epam.task1A.factory;

import by.epam.task1A.action.FigureCalculation;
import by.epam.task1A.entity.Plane;
import by.epam.task1A.exception.ExtendedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class PlaneFactory<T> implements FigureFactory<Plane> {
    static Logger logger = LogManager.getLogger();
    private static PlaneFactory<Plane> instance;

    public static PlaneFactory<Plane> getInstance() {
        if (null == instance) {
            instance = new PlaneFactory<>();
        }
        return instance;
    }

    @Override
    public ArrayList<Plane> createFigures(ArrayList<String> figuresList) {
        ArrayList<Plane> planeList = new ArrayList<>();
        FigureBuilder planeBuilder = PlaneBuilder.getInstance();
        FigureCalculation calculation = new FigureCalculation();
        for (String figure : figuresList
                ) {
            try {
                Plane plane = (Plane) planeBuilder.createFigure(figure);
                if (plane != null && calculation.checkIfThreeDotsIsPlane(plane.getA(), plane.getB(), plane.getC())) {
                    planeList.add(plane);
                } else {
                    logger.error(" Points does not build plane");
                }
            } catch (ExtendedException e) {
                logger.error(" Builder failed", e);
            }
        }
        return planeList;
    }
}
