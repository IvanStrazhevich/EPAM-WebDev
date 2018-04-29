package by.epam.task1b.registrar;

public interface AbstractObserver<T> {
    void handleEvent(FigureEvent event);
}
