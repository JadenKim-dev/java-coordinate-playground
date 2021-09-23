package rent;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    public static final String SEPARATOR = " : ";
    public static final String NEWLINE = System.lineSeparator();
    private final List<Car> carList;

    private RentCompany() {
        this.carList = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(final Car car) {
        this.carList.add(car);
    }

    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            sb.append(car.getName()).append(SEPARATOR)
                    .append((int)car.getChargeQuantity()).append("리터").append(NEWLINE);
        }
        return sb.toString();
    }
}
