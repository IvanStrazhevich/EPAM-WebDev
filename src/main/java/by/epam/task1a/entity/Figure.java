package by.epam.task1a.entity;

import by.epam.task1b.registrar.FigureObservable;
import by.epam.task1b.registrar.FigureEvent;
import by.epam.task1b.registrar.AbstractObserver;
import by.epam.task1b.registrar.FigureObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class Figure implements FigureObservable {
    static Logger logger = LogManager.getLogger();

    private FigureObserver figureObserver;
    private long id;

    public Figure() {
        this.id = UUID.randomUUID().getMostSignificantBits();
    }

    public void identifyFigure() {
        logger.info("Figure is done");
    }

    @Override
    public void attach(AbstractObserver observer) {
        this.figureObserver = (FigureObserver) observer;
        ((FigureObserver) observer).addObservable(this);
    }

    @Override
    public void detach(AbstractObserver observer) {
        this.figureObserver = (FigureObserver) observer;
        ((FigureObserver) observer).removeObservable(this);
    }

    @Override
    public void notifyObservers() {
        if (figureObserver != null) {
            figureObserver.handleEvent(new FigureEvent(this));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Figure figure = (Figure) o;

        if (id != figure.id) return false;
        return figureObserver != null ? figureObserver.equals(figure.figureObserver) : figure.figureObserver == null;
    }

    @Override
    public int hashCode() {
        int result = figureObserver != null ? figureObserver.hashCode() : 0;
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Figure { " +
                "figureObserver = " + figureObserver +
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
