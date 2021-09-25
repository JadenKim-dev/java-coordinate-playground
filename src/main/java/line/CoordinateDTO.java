package line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CoordinateDTO {

    public static final String DELIMITER = "-";
    public static final String COMMA = ",";

    private final int x;
    private final int y;

    private CoordinateDTO(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static CoordinateDTO newInstance(int x, int y) {
        return new CoordinateDTO(x, y);
    }

    public static CoordinateDTO from(Coordinate coordinate) {
        return new CoordinateDTO(
                coordinate.getX().getValue(),
                coordinate.getY().getValue()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinateDTO that = (CoordinateDTO) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
