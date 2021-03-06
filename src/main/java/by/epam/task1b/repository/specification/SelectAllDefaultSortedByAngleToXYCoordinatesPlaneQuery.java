package by.epam.task1b.repository.specification;

import by.epam.task1a.entity.Figure;
import by.epam.task1b.repository.comparator.CompareByAngleToXYPlane;
import by.epam.task1b.repository.storage.FigureStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SelectAllDefaultSortedByAngleToXYCoordinatesPlaneQuery<R> implements QuerySpecification<ArrayList<Figure>> {
    static Logger logger = LogManager.getLogger();
    private Comparator<Figure> comparator;

    public SelectAllDefaultSortedByAngleToXYCoordinatesPlaneQuery(Comparator<Figure> comparatorByAngleXYDefault) {
        this.comparator = comparatorByAngleXYDefault;
    }

    public SelectAllDefaultSortedByAngleToXYCoordinatesPlaneQuery() {
    }

    @Override
    public ArrayList<Figure> executeQuery() {
        ArrayList<Figure> figureList = FigureStorage.getInstance().getFigureList();
        logger.debug("Before sort: " + figureList);
        if (comparator == null) {
            comparator = new CompareByAngleToXYPlane();
        }
        Collections.sort(figureList, comparator);
        logger.debug("After sort: " + figureList);
        return figureList;
    }

    public void setComparator(Comparator<Figure> comparator) {
        this.comparator = comparator;
    }
}
