package line;

public class LengthCalculatorController {
    private final InputView inputView;
    private final LengthFormatParser parser;

    private LengthCalculatorController() {
        inputView = InputView.newInstance();
        parser = new LengthFormatParser();
    }

    public static LengthCalculatorController newInstance() {
        return new LengthCalculatorController();
    }

    public void calculate() {
        Coordinates coordinates = getCoordinatesFromInput();
        ResultView resultView = ResultView.newInstance();
        resultView.printGraph(coordinates);
        resultView.printLength(coordinates.getLength());
    }

    private Coordinates getCoordinatesFromInput() {
        try {
            String coordinatesString = inputView.inputCoordinates();
            return parser.parseCoordinates(coordinatesString);
        } catch (IllegalArgumentException e) {
            inputView.printReinputMessage();
            return getCoordinatesFromInput();
        }
    }

}
