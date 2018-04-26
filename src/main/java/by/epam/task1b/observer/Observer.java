package by.epam.task1b.observer;

import by.epam.task1a.entity.Figure;

import java.util.ArrayList;

public class Observer<T> implements FigureObserver<Figure> {

    ArrayList<Figure> observableList;

    public void addObservable(Figure observable) {
        observableList.add(observable);
    }

    public void removeObservable(Figure observable) {
        observableList.remove(observable);
    }

    @Override
    public void handleEvent(FigureEvent event) {
        Figure figure = event.getSource();
        DataUpdatable updater = new PlaneDataUpdater();
        updater.update(figure);
    }
}
