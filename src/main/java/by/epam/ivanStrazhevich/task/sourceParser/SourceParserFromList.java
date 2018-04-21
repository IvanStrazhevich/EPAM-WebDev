package by.epam.ivanStrazhevich.task.sourceParser;

import by.epam.ivanStrazhevich.task.validator.SourceValidatable;
import by.epam.ivanStrazhevich.task.validator.SourceValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SourceParserFromList<T> implements SourceParsable<ArrayList<String>> {
    Logger logger = LogManager.getLogger();
    private static final String POINT_COORDINATE_PATTERN = "\\d+(\\.\\d+)(\\s)?";

    @Override
    public ArrayList<Double> parsePointDataToCoordinatesList(ArrayList<String> dotsForPlaneList) {
        ArrayList<Double> dotCoordinatesList = new ArrayList<>();
        SourceValidatable<ArrayList<String>> sourceValidator = new SourceValidator<>();
        if (dotsForPlaneList != null && sourceValidator.validateSourceList(dotsForPlaneList)) {
            Pattern pattern = Pattern.compile(POINT_COORDINATE_PATTERN);

            for (String dotsForPlane : dotsForPlaneList
                    ) {
                Matcher matcher = pattern.matcher(dotsForPlane);
                while (matcher.find()) {
                    dotCoordinatesList.add(Double.parseDouble(matcher.group()));
                }
            }
        }
        logger.debug(dotCoordinatesList);
        return dotCoordinatesList;
    }
}
