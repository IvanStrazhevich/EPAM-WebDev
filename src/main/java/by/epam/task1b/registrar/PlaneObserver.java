package by.epam.task1b.registrar;

import by.epam.task1a.entity.Figure;

import java.util.ArrayList;

public class PlaneObserver<T> implements AbstractObserver<Figure> {
    private static PlaneObserver instance;
    private ArrayList<Figure> observableList = new ArrayList<>();
    private DataUpdatable updater;

    private PlaneObserver(DataUpdatable updater) {
        this.updater = updater;
    }
    public static final PlaneObserver getInstance() {
        if (instance == null) {
            instance = new PlaneObserver(new PlaneDataUpdater());
        }
        return instance;
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
