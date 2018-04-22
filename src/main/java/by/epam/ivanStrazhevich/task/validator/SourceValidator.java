package by.epam.ivanStrazhevich.task.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class SourceValidator<T> implements SourceValidatable<ArrayList<String>> {
    Logger logger = LogManager.getLogger();
    private static final String PLANE_POINTS_PATTERN = "^\\d+(\\.\\d+)\\s\\d+(\\.\\d+)\\s\\d+(\\.\\d+)\\s" +
            "\\d+(\\.\\d+)\\s\\d+(\\.\\d+)\\s\\d+(\\.\\d+)\\s" +
            "\\d+(\\.\\d+)\\s\\d+(\\.\\d+)\\s\\d+(\\.\\d+)";
    private static final String POINT_COORDINATE_PATTERN = "\\d+(\\.\\d+)(\\s)?";

    @Override
    public boolean validateSourceList(ArrayList<String> dataSourceList) {
        String pattern = PLANE_POINTS_PATTERN;
        for (String line : dataSourceList
                ) {
            logger.debug(line + " Source list validator");
            if (!line.matches(pattern)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean validateCorrectLinePointsForPlane(String coordinatesLine) {
        logger.debug(coordinatesLine + " Line validator");
        return coordinatesLine.matches(PLANE_POINTS_PATTERN);
    }

    @Override
    public boolean validateCoordinateDataForPoint(String coordinate) {
        logger.debug(coordinate + " Dot coordinate validator");
        return coordinate.matches(POINT_COORDINATE_PATTERN);
    }

}
