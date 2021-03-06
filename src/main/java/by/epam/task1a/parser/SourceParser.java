package by.epam.task1a.parser;

import by.epam.task1a.validator.SourceValidatable;
import by.epam.task1a.validator.SourceValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SourceParser<T> implements SourceParsable<ArrayList<String>> {
    static Logger logger = LogManager.getLogger();
    private static final String POINT_COORDINATE_PATTERN = "(\\-)?\\d+(\\.\\d+)(\\s)?";
    private static final String POINT_PATTERN = "(\\-)?\\d+(\\.\\d+)(\\s)(\\-)?\\d+(\\.\\d+)(\\s)(\\-)?\\d+(\\.\\d+)(\\s)?";

    @Override
    public ArrayList<String> excludeWrongLineAtPlaneCoordinatesDataFromList(ArrayList<String> dotsForPlaneList) {
        ArrayList<String> dotCoordinatesList = new ArrayList<>();
        SourceValidatable<ArrayList<String>> sourceValidator = new SourceValidator<>();
        Pattern pattern = Pattern.compile(POINT_COORDINATE_PATTERN);
        if (dotsForPlaneList != null) {
            for (String dotsForPlane : dotsForPlaneList
                    ) {
                if (sourceValidator.validateCorrectLinePointsForPlane(dotsForPlane)) {
                    Matcher matcher = pattern.matcher(dotsForPlane);
                    StringBuffer dot = new StringBuffer();
                    while (matcher.find()) {
                        dot.append(matcher.group());
                    }
                    dotCoordinatesList.add(dot.toString());
                }
            }
        }
        logger.debug(dotCoordinatesList + " Parser to planes result");
        return dotCoordinatesList;
    }

    @Override
    public ArrayList<String> createDotListFromList(ArrayList<String> planeDataList) {
        ArrayList<String> dotList = new ArrayList<>();
        Pattern pattern = Pattern.compile(POINT_PATTERN);
        for (String planeData : planeDataList
                ) {
            Matcher matcher = pattern.matcher(planeData);
            while (matcher.find()) {
                String dot = matcher.group();
                dotList.add(dot);
            }
        }
        logger.debug(dotList + " Parser to dots result");
        return dotList;
    }

    @Override
    public ArrayList<String> createDotListFromString(String planeData) {
        ArrayList<String> dotList = new ArrayList<>();
        Pattern pattern = Pattern.compile(POINT_PATTERN);
        Matcher matcher = pattern.matcher(planeData);
        while (matcher.find()) {
            String dot = matcher.group();
            dotList.add(dot);
        }
        logger.debug(dotList + " Parser to dots result");
        return dotList;
    }
}
