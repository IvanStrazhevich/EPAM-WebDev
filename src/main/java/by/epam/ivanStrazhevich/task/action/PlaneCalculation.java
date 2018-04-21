package by.epam.ivanStrazhevich.task.action;

import by.epam.ivanStrazhevich.task.entity.Plane;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlaneCalculation implements Planeable{
    static Logger logger = LogManager.getLogger(PlaneCalculation.class.getName());

    public double countAngle(Plane plane) {
        logger.log(Level.ALL, "Green-green, Yello");

        return 0;

    }

    public boolean checkIfPlane(Plane plane) {

        return false;
    }

    public boolean checkIfPlanePerpendicularDatumLine(Plane plane) {
        return false;
    }
}
