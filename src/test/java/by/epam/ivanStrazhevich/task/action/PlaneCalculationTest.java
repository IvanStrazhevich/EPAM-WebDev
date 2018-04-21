package by.epam.ivanStrazhevich.task.action;

import by.epam.ivanStrazhevich.task.entity.Plane;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PlaneCalculationTest {

    @Test
    public void testCountAngle() {
        PlaneCalculation planeCalculation = new PlaneCalculation();
        Plane plane = new Plane();
        planeCalculation.countAngle(plane);
    }

    @Test
    public void testCheckIfPlane() {
    }

    @Test
    public void testCheckIfPlanePerpendicularDatumLine() {
    }
}