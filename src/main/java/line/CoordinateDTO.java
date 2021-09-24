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

    public static List<CoordinateDTO> parseCoordinateDTOs(String input) {
        ArrayList<Integer> values = new ArrayList<>();

        List<String> separatedInput = Arrays.stream(input.split(DELIMITER))
                .map(substring -> substring.split(COMMA))
                .flatMap(Arrays::stream).collect(Collectors.toList());

        for (int i = 0; i < separatedInput.size(); i++) {
            addIthValueFromInput(values, separatedInput, i);
        }

        return convertToCoordinateDTOs(values);
    }

    private static void addIthValueFromInput(ArrayList<Integer> values, List<String> separatedInput, int i) {
        String partialInput = separatedInput.get(i);
        if (i % 2 == 0) {
            values.add(Integer.parseInt(partialInput.substring(1)));
            return;
        }
        values.add(Integer.parseInt(partialInput.substring(0, partialInput.length() - 1)));
    }

    private static ArrayList<CoordinateDTO> convertToCoordinateDTOs(ArrayList<Integer> values) {
        ArrayList<CoordinateDTO> coordinateDTOs = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            coordinateDTOs.add(
                    CoordinateDTO.newInstance(values.get(2*i), values.get(2*i + 1))
            );
        }
        return coordinateDTOs;
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
