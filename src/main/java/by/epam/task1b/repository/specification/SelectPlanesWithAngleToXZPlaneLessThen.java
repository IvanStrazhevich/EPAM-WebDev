package by.epam.task1b.repository.specification;

import by.epam.task1a.entity.Figure;
import by.epam.task1b.registrar.PlaneDataRegistrar;
import by.epam.task1b.repository.comparator.CompareById;
import by.epam.task1b.repository.storage.FigureStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class SelectPlanesWithAngleToXZPlaneLessThen<R, T> implements QuerySpecification<ArrayList<Figure>> {
    static Logger logger = LogManager.getLogger();
    private double angleToCompareTo;
    private Comparator<Figure> comparator;

    public SelectPlanesWithAngleToXZPlaneLessThen(Double angleToCompareTo, Comparator<Figure> comparator) {
        this.angleToCompareTo = angleToCompareTo;
        this.comparator = comparator;
    }

    public SelectPlanesWithAngleToXZPlaneLessThen(double angleToCompareTo) {
        this.angleToCompareTo = angleToCompareTo;
    }

    @Override
    public ArrayList<Figure> executeQuery() {
        ArrayList<Figure> figureList = FigureStorage.getInstance().getFigureList();
        ArrayList<Figure> filteredFigureList = new ArrayList<>();
        HashMap<Long, Double> angleXZMap = PlaneDataRegistrar.getInstance().getFigureAngleXZHashMap();
        logger.debug("Before sort: " + figureList);
        for (Figure figure : figureList
                ) {
            if (figure != null && angleXZMap !=null && angleXZMap.get(figure.getId()).compareTo(angleToCompareTo) < 0) {
                filteredFigureList.add(figure);
            }
        }
        if(comparator==null){
            comparator = new CompareById();
        }
        Collections.sort(filteredFigureList, comparator);
        logger.debug("After sort: " + filteredFigureList);
        return filteredFigureList;
    }

    public void setAngleToCompareTo(double angleToCompareTo) {
        this.angleToCompareTo = angleToCompareTo;
    }

    public void setComparator(Comparator<Figure> comparator) {
        this.comparator = comparator;
    }
}
