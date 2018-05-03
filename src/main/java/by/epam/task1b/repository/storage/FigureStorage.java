package by.epam.task1b.repository.storage;

import by.epam.task1a.entity.Figure;

import java.util.ArrayList;

public class FigureStorage {
    private ArrayList<Figure> figureList;
    private static FigureStorage instance;

    private FigureStorage(ArrayList<Figure> list) {
        this.figureList = list;
    }

    public static final FigureStorage getInstance() {
        if (instance == null) {
            instance = new FigureStorage(new ArrayList<>());
        }
        return instance;
    }

    public ArrayList<Figure> getFigureList() {
        return figureList;
    }
}
