package by.epam.ivanStrazhevich.task.factory;

public class PlaneFactory {
    private PlaneFactory() {
    }

    private static PlaneFactory instance;

    public static PlaneFactory getInstance() {
        if (null == instance) {
            instance = new PlaneFactory();
        }
        return instance;
    }
}
