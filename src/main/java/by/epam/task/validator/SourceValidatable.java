package by.epam.task.validator;


public interface SourceValidatable<T> {
    boolean validateSourceList(T dataSourceList);
    boolean validateCorrectLinePointsForPlane(String coordinatesLine);
    boolean validateCoordinatesForPoint(String coordinatesLine);
    boolean validateDataForPoint(String dot);
}
