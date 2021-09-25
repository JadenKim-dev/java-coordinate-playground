package line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Coordinates {
    private final List<Coordinate> coordinateList;

    private Coordinates(List<Coordinate> coordinateList) {
        this.coordinateList = coordinateList;
    }

    public static Coordinates of(List<Coordinate> coordinateList) {
        return new Coordinates(coordinateList);
    }

    public Coordinate get(int index) {
        return coordinateList.get(index);
    }

    public boolean containsAll(Coordinate... coordinates) {
        return coordinateList.containsAll(List.of(coordinates));
    }
}
