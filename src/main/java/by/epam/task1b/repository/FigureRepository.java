package by.epam.task1b.repository;

import by.epam.task1a.entity.Figure;
import by.epam.task1b.registrar.PlaneObserver;
import by.epam.task1b.repository.specification.QuerySpecification;
import by.epam.task1b.repository.storage.FigureStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class FigureRepository<T> implements Repositorable<Figure> {
    static Logger logger = LogManager.getLogger();

    @Override
    public boolean add(Figure figure) {
        FigureStorage figureStorage = FigureStorage.getInstance();
        figure.attach(PlaneObserver.getInstance());
        figure.notifyObservers();
        return figureStorage.getFigureList().add(figure);
    }

    @Override
    public boolean remove(Figure figure) {
        FigureStorage figureStorage = FigureStorage.getInstance();
        figure.notifyObservers();
        return figureStorage.getFigureList().remove(figure);
    }

    @Override
    public boolean update(Figure figure) {
        FigureStorage figureStorage = FigureStorage.getInstance();
        ArrayList<Figure> figureList = figureStorage.getFigureList();
        for (Figure item : figureList
                ) {
            if (item.getId() == figure.getId()) {
                item.notifyObservers();
                logger.debug("remove is " + figureList.remove(item));
                figureList.add(figure);
            }
        }
        return figureStorage.getFigureList().add(figure);
    }

    @Override
    public boolean addAll(ArrayList<Figure> list) {
        FigureStorage figureStorage = FigureStorage.getInstance();
        ArrayList<Figure> figureList = figureStorage.getFigureList();
        for (Figure item : list
                ) {
            item.attach(PlaneObserver.getInstance());
            item.notifyObservers();
            figureList.add(item);

        }
        return !figureList.isEmpty();
    }

    @Override
    public ArrayList<Figure> query(QuerySpecification specification) {
        return (ArrayList<Figure>) specification.executeQuery();
    }
}
