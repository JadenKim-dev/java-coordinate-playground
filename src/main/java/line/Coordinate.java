package line;

import java.util.Objects;

public class Coordinate {

    private final Value x;
    private final Value y;

    public Coordinate(int x, int y) {
        this.x = Value.of(x);
        this.y = Value.of(y);
    }

    public static Coordinate of(int x, int y) {
        return new Coordinate(x, y);
    }

    public double calculateLengthTo(Coordinate point) {
        return Math.sqrt(
                Math.pow(x.getDifferenceTo(point.getX()), 2)
                + Math.pow(y.getDifferenceTo(point.getY()), 2)
        );
    }

    public Value getX() {
        return Value.copyOf(x);
    }

    public Value getY() {
        return Value.copyOf(y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equals(getX(), that.getX()) && Objects.equals(getY(), that.getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
