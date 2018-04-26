package by.epam.task1b.repository;

import by.epam.task1a.entity.Figure;

import java.util.ArrayList;

public class FigureReposirory<T> implements Reposirory<Figure> {
    @Override
    public boolean add(Figure figure) {
        FigureStorage figureStorage = FigureStorage.getInstance();
        figureStorage.getFigureList().add(figure);
        return true;
    }

    @Override
    public boolean remove(Figure figure) {
        FigureStorage figureStorage = FigureStorage.getInstance();
        figureStorage.getFigureList().remove(figure);
        return true;
    }

    @Override
    public boolean update(Figure figure) {
        FigureStorage figureStorage = FigureStorage.getInstance();
        ArrayList<Figure> figureList = figureStorage.getFigureList();
        for (Figure item : figureList
                ) {
            if (item.getId() == figure.getId()) {
                figureList.add(figureList.indexOf(item), figure);
                figureList.remove(item);
            }
        }
        figureStorage.getFigureList().add(figure);
        return true;
    }

    @Override
    public ArrayList<Figure> query(QuerySpecification specification) {
        return null;
    }
}
