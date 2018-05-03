package by.epam.task1a.entity;

import by.epam.task1b.registrar.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class Figure implements FigureObservable {
    static Logger logger = LogManager.getLogger();

    private PlaneObserver planeObserver;
    private long id;

    public Figure() {
        this.id = UUID.randomUUID().getMostSignificantBits();
    }

    public void identifyFigure() {
        logger.info("Figure is done");
    }

    @Override
    public void attach(AbstractObserver observer) {
        this.planeObserver = (PlaneObserver) observer;
        ((PlaneObserver) observer).addObservable(this);
    }

    @Override
    public void detach(AbstractObserver observer) {
        this.planeObserver = (PlaneObserver) observer;
        ((PlaneObserver) observer).removeObservable(this);
    }

    @Override
    public void notifyObservers() {
        if (planeObserver != null) {
            planeObserver.handleEvent(new FigureEvent(this));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Figure figure = (Figure) o;

        if (id != figure.id) return false;
        return planeObserver != null ? planeObserver.equals(figure.planeObserver) : figure.planeObserver == null;
    }

    @Override
    public int hashCode() {
        int result = planeObserver != null ? planeObserver.hashCode() : 0;
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Figure { " +
                "planeObserver = " + planeObserver +
                ", id = " + id +
                " } ";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PlaneObserver getPlaneObserver() {
        return planeObserver;
    }

    public void setPlaneObserver(PlaneObserver planeObserver) {
        this.planeObserver = planeObserver;
    }
}
