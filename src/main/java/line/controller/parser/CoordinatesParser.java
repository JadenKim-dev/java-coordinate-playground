package line.controller.parser;

import line.domain.Coordinates;

public interface CoordinatesParser {
    boolean validatePattern(String input);
    Coordinates parseCoordinates(String input);
}
