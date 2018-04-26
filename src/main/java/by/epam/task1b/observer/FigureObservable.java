package by.epam.task1b.observer;

public interface FigureObservable {
    void attach(FigureObserver observer);

    void detach(FigureObserver observer);

    void notifyObservers();
}
