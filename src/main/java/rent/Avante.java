package rent;

public class Avante extends Car {
    private static final double DISTANCE_PER_LITER = 15;
    private final double tripDistance;

    public Avante(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    public double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    public double getTripDistance() {
        return tripDistance;
    }

    public String getName() {
        return getClass().getSimpleName();
    }
}
