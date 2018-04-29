package by.epam.task1b.coparator;

import by.epam.task1a.entity.Figure;

import java.util.Comparator;

public class CompareById implements Comparator<Figure> {
    @Override
    public int compare(Figure o1, Figure o2) {
        return Double.compare(o1.getId(),o2.getId());
    }
}
