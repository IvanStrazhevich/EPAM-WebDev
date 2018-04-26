package by.epam.task1B.observer;

import by.epam.task1A.action.FigureCalculation;
import by.epam.task1A.entity.Figure;
import by.epam.task1A.entity.Plane;
import by.epam.task1B.repository.FigureDataStorage;

import java.util.ArrayList;

public class Observer<T> implements FigureObserver<Figure> {
    ArrayList<Figure> observableList;

    public void addObservable(Figure observable) {
        observableList.add(observable);
    }

    public void removeObservable(Figure observable) {
        observableList.remove(observable);
    }

    @Override
    public void handleEvent(FigureEvent event) {
        FigureDataStorage dataStorage = FigureDataStorage.getInstance();
        Figure figure = event.getSource();
        FigureCalculation figureCalculation = new FigureCalculation();
        double planeXYAngle = figureCalculation.countAngleToXYPlaneGrad((Plane)figure);
        double planeXZAngle = figureCalculation.countAngleToXYPlaneGrad((Plane)figure);
        double planeYZAngle = figureCalculation.countAngleToXYPlaneGrad((Plane)figure);
        dataStorage.getFigureAngleXYHashMap().put(figure.getId(),planeXYAngle);
        dataStorage.getFigureAngleXZHashMap().put(figure.getId(),planeXZAngle);
        dataStorage.getFigureAngleYZHashMap().put(figure.getId(),planeYZAngle);
    }
}
