package rent;

public class K5 extends Car {
    private static final double DISTANCE_PER_LITER = 13;
    private final double tripDistance;

    public K5(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    public double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    public double getTripDistance() {
        return tripDistance;
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
