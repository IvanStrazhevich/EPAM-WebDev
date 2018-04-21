package by.epam.ivanStrazhevich.task.factory;

public class PointFactory {
    private PointFactory() {
    }

    private static PointFactory instance;

    public static PointFactory getInstance() {
        if (null == instance) {
            instance = new PointFactory();
        }
        return instance;
    }

}
