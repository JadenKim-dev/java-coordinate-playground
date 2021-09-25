package line;

public interface CoordinatesParser {
    boolean validatePattern(String input);
    Coordinates parseCoordinates(String input);
}
