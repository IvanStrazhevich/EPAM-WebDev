package by.epam.task1B.observer;

import by.epam.task1A.entity.Figure;

import java.util.EventObject;

public class FigureEvent extends EventObject {

    public FigureEvent(Figure source) {
        super(source);
    }

    @Override
    public Figure getSource() {
        return (Figure) super.getSource();
    }
}