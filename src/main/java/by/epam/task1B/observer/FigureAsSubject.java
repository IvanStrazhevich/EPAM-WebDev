package by.epam.task1B.observer;

public interface FigureAsSubject {
    void attach(FiguresObserver observer);
    void deTach(FiguresObserver observer);
    void notifyObservers();
}
