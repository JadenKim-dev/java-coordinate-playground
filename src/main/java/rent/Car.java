package rent;

public abstract class Car implements CarInterface {
    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
