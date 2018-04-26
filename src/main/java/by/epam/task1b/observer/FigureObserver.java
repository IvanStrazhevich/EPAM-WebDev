package by.epam.task1b.observer;

public interface FigureObserver<T> {
    void handleEvent(FigureEvent event);
}
