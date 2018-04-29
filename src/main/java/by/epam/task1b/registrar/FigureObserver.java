package by.epam.task1b.registrar;

import by.epam.task1a.entity.Figure;

import java.util.ArrayList;

public class FigureObserver<T> implements AbstractObserver<Figure> {

    private ArrayList<Figure> observableList;
    DataUpdatable updater;

    public FigureObserver(DataUpdatable updater) {
        this.updater = updater;
    }

    public void addObservable(Figure observable) {
        observableList.add(observable);
    }

    public void removeObservable(Figure observable) {
        observableList.remove(observable);
    }

    @Override
    public void handleEvent(FigureEvent event) {
        Figure figure = event.getSource();
        updater.update(figure);
    }

    public void setUpdater(DataUpdatable updater) {
        this.updater = updater;
    }
}
