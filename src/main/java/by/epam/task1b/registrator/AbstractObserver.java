package by.epam.task1b.registrator;

public interface AbstractObserver<T> {
    void handleEvent(FigureEvent event);
}
