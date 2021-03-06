package by.epam.task1b.registrar;

import by.epam.task1a.action.FigureCalculation;
import by.epam.task1a.entity.Plane;

import java.util.HashMap;

public class PlaneDataUpdater<T> implements DataUpdatable<Plane> {
    @Override
    public void update(Plane plane) {
        PlaneDataRegistrar<HashMap> dataRegistrant = PlaneDataRegistrar.getInstance();
        FigureCalculation figureCalculation = new FigureCalculation();
        double planeXYAngle = figureCalculation.countAngleToXYPlaneGrad(plane);
        double planeXZAngle = figureCalculation.countAngleToXZPlaneGrad(plane);
        double planeYZAngle = figureCalculation.countAngleToYZPlaneGrad(plane);
        long figureId = plane.getId();
        dataRegistrant.getFigureAngleXYHashMap().put(figureId,planeXYAngle);
        dataRegistrant.getFigureAngleXZHashMap().put(figureId,planeXZAngle);
        dataRegistrant.getFigureAngleYZHashMap().put(figureId,planeYZAngle);
    }
}
