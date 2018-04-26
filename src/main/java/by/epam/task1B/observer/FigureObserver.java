package by.epam.task1B.observer;

public interface FigureObserver<T> {
    void handleEvent(FigureEvent event);
}
