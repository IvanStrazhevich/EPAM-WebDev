package by.epam.ivanStrazhevich.task.validator;

import java.util.ArrayList;

public class SourceValidator<T> implements SourceValidatable<ArrayList<String>> {
    private static final String PLANE_POINTS_PATTERN = "^\\d+(\\.\\d+)\\s\\d+(\\.\\d+)\\s\\d+(\\.\\d+)\\s" +
            "\\d+(\\.\\d+)\\s\\d+(\\.\\d+)\\s\\d+(\\.\\d+)\\s" +
            "\\d+(\\.\\d+)\\s\\d+(\\.\\d+)\\s\\d+(\\.\\d+)";
    private static final String POINT_COORDINATE_PATTERN = "\\d+(\\.\\d+)(\\s)?";

    @Override
    public boolean validateSourceList(ArrayList<String> dataSourceList) {
        String pattern = PLANE_POINTS_PATTERN;
        for (String line : dataSourceList
                ) {
            if (!line.matches(pattern)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean validateCorrectLinePointsForPlane(String coordinatesLine) {
        return coordinatesLine.matches(PLANE_POINTS_PATTERN);
    }

}
