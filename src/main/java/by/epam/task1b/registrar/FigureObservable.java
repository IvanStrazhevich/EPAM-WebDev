package by.epam.task1b.registrar;

public interface FigureObservable {
    void attach(AbstractObserver observer);

    void detach(AbstractObserver observer);

    void notifyObservers();
}
