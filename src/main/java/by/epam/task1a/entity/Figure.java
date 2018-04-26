package by.epam.task1a.entity;

import by.epam.task1b.observer.FigureObservable;
import by.epam.task1b.observer.FigureEvent;
import by.epam.task1b.observer.FigureObserver;
import by.epam.task1b.observer.Observer;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Figure figure = (Figure) o;

        if (id != figure.id) return false;
        return observer != null ? observer.equals(figure.observer) : figure.observer == null;
    }

    @Override
    public int hashCode() {
        int result = observer != null ? observer.hashCode() : 0;
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Figure { " +
                "observer = " + observer +
                ", id = " + id +
                " }";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
