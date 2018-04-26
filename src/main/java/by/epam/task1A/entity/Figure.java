package by.epam.task1A.entity;

import by.epam.task1B.observer.FigureObservable;
import by.epam.task1B.observer.FigureEvent;
import by.epam.task1B.observer.FigureObserver;
import by.epam.task1B.observer.Observer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class Figure implements FigureObservable {
    static Logger logger = LogManager.getLogger();

    private Observer observer;
    private long id;

    public Figure() {
        this.id = UUID.randomUUID().getMostSignificantBits();
    }

    public void identifyFigure() {
        logger.info("Figure is done");
    }

    @Override
    public void attach(FigureObserver observer) {
        this.observer = (Observer) observer;
        ((Observer) observer).addObservable(this);
    }

    @Override
    public void detach(FigureObserver observer) {
        this.observer = (Observer) observer;
        ((Observer) observer).removeObservable(this);
    }

    @Override
    public void notifyObservers() {
        if (observer != null) {
            observer.handleEvent(new FigureEvent(this));
        }
    }

    @Override
    public String toString() {
        return "Figure { " +
                " observer = " + observer +
                " }";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
