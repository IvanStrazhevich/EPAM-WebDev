package by.epam.ivanStrazhevich.task.sourceReader;

import by.epam.ivanStrazhevich.task.exception.ExtendedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SourceReader<T> implements SourceReadable<ArrayList<String>> {
    static Logger logger = LogManager.getLogger();

    public ArrayList<String> readSource(String pointDataSource) throws ExtendedException {
        ArrayList<String> planeDataList = new ArrayList<>();
        if (pointDataSource != null) {
            Path path = Paths.get(pointDataSource);
            try (Stream<String> lines = Files.lines(path)) {
                planeDataList = (ArrayList) lines.collect(Collectors.toList());
            } catch (IOException e) {
                logger.error("Source file problem", e);
                throw new ExtendedException("Source file problem", e);
            }
            logger.debug(planeDataList);
        }
        return planeDataList;
    }

}
