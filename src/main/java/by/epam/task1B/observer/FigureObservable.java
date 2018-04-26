package by.epam.task1B.observer;

public interface FigureObservable {
    void attach(FigureObserver observer);

    void detach(FigureObserver observer);

    void notifyObservers();
}
