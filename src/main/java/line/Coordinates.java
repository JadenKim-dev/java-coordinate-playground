package line;

import java.util.List;
import java.util.stream.Stream;

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

    public Stream<Coordinate> stream() {
        return coordinateList.stream();
    }

    public double getLength() {
        return coordinateList.get(0)
                .calculateLengthTo(coordinateList.get(1));
    }
}
