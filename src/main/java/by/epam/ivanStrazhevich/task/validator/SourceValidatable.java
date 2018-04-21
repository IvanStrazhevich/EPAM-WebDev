package by.epam.ivanStrazhevich.task.validator;


public interface SourceValidatable<T> {
    boolean validateSourceList(T dataSourceList);
    boolean validateCorrectLinePointsForPlane(String coordinatesLine);
}
