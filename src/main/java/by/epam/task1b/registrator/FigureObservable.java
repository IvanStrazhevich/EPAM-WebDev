package by.epam.task1b.registrator;

public interface FigureObservable {
    void attach(AbstractObserver observer);

    void detach(AbstractObserver observer);

    void notifyObservers();
}
