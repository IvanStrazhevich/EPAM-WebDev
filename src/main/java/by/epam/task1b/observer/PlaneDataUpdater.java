package by.epam.task1b.observer;

import by.epam.task1a.action.FigureCalculation;
import by.epam.task1a.entity.Figure;
import by.epam.task1a.entity.Plane;
import by.epam.task1b.repository.FigureDataStorage;

public class PlaneDataUpdater implements DataUpdatable {
    @Override
    public void update(Figure figure) {
        FigureDataStorage dataStorage = FigureDataStorage.getInstance();
        FigureCalculation figureCalculation = new FigureCalculation();
        double planeXYAngle = figureCalculation.countAngleToXYPlaneGrad((Plane)figure);
        double planeXZAngle = figureCalculation.countAngleToXYPlaneGrad((Plane)figure);
        double planeYZAngle = figureCalculation.countAngleToXYPlaneGrad((Plane)figure);
        dataStorage.getFigureAngleXYHashMap().put(figure.getId(),planeXYAngle);
        dataStorage.getFigureAngleXZHashMap().put(figure.getId(),planeXZAngle);
        dataStorage.getFigureAngleYZHashMap().put(figure.getId(),planeYZAngle);
    }
}
