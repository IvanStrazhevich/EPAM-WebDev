package by.epam.task1A.factory;

import java.util.ArrayList;

public interface FigureFactory <T> {
    ArrayList<T> createFigures(ArrayList<String> figuresList);
}
