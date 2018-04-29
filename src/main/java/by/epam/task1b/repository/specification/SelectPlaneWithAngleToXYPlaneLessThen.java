package by.epam.task1b.repository.specification;

import by.epam.task1a.entity.Figure;
import by.epam.task1b.registrator.PlaneDataRegistrar;
import by.epam.task1b.repository.storage.FigureStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class SelectPlaneWithAngleToXYPlaneLessThen<R, T> implements QuerySpecification<ArrayList<Figure>> {
    static Logger logger = LogManager.getLogger();
    private double angleToCompareTo;
    private Comparator<Figure> comparator;

    public SelectPlaneWithAngleToXYPlaneLessThen(Double angleToCompareTo, Comparator<Figure> comparator) {
        this.angleToCompareTo = angleToCompareTo;
        this.comparator = comparator;
    }

    @Override
    public ArrayList<Figure> executeQuery() {
        ArrayList<Figure> figureList = FigureStorage.getInstance().getFigureList();
        ArrayList<Figure> filteredFigureList = new ArrayList<>();
        HashMap<Long, Double> angleXYMap = PlaneDataRegistrar.getInstance().getFigureAngleXYHashMap();
        logger.debug("Before sort: " + figureList);
        for (Figure figure : figureList
                ) {
            if (angleXYMap.get(figure.getId()).compareTo(angleToCompareTo) < 0) {
                filteredFigureList.add(figure);
            }
        }
        Collections.sort(filteredFigureList, comparator);
        logger.debug("After sort: " + filteredFigureList);
        return filteredFigureList;
    }

    public void setAngleToCompareTo(double angleToCompareTo) {
        this.angleToCompareTo = angleToCompareTo;
    }
}
