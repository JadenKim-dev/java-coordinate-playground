package line.controller.parser;

import line.domain.Coordinate;
import line.domain.Coordinates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LengthFormatParser implements CoordinatesParser{

    private static final String DELIMITER = "-";
    private static final String COMMA = ",";
    private static final String PATTERN = "^\\(\\d{1,2},\\d{1,2}\\)-\\(\\d{1,2},\\d{1,2}\\)$";

    @Override
    public boolean validatePattern(String input) {
        return input.matches(PATTERN);
    }

    @Override
    public Coordinates parseCoordinates(String input) {
        if(!validatePattern(input)) {
            throw new IllegalArgumentException("올바르지 않은 입력 형식입니다.");
        }
        List<Integer> valueList = Arrays.stream(input.split(DELIMITER))
                .map(substring -> substring.split(COMMA))
                .flatMap(Arrays::stream)
                .map(string -> string.replace("(", ""))
                .map(string -> string.replace(")", ""))
                .map(Integer::parseInt).collect(Collectors.toList());

        return Coordinates.of(getCoordinateListFrom(valueList));
    }

    private static List<Coordinate> getCoordinateListFrom(List<Integer> valueList) {
        List<Coordinate> coordinateList = new ArrayList<>();
        for (int i = 0; i < valueList.size()/2; i++) {
            coordinateList.add(
                    Coordinate.of(valueList.get(2*i), valueList.get(2*i + 1))
            );
        }
        return coordinateList;
    }
}
