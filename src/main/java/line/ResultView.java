package line;

public class ResultView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final int MAX_AXIS_VALUE = 24;
    private static final int MIN_AXIS_VALUE = 0;
    private static final String Y_AXIS_LINE_UNIT = "|";
    private static final String POINT = ".";
    private static final String DOUBLE_BLANK = "  ";

    private final CoordinateDTO coordinate1;
    private final CoordinateDTO coordinate2;

    private ResultView(CoordinateDTO coordinateDTO1, CoordinateDTO coordinateDTO2) {
        this.coordinate1 = coordinateDTO1;
        this.coordinate2 = coordinateDTO2;
    }

    public static ResultView newInstance(CoordinateDTO coordinateDTO1, CoordinateDTO coordinateDTO2) {
        return new ResultView(coordinateDTO1, coordinateDTO2);
    }

    public void printGraph() {
        StringBuilder sb = new StringBuilder();
        for (int y = MAX_AXIS_VALUE; y > MIN_AXIS_VALUE; y--) {
            appendYAxis(sb, y);
            sb.append(Y_AXIS_LINE_UNIT);
            appendCoordinateOrPass(sb, y);
        }
        sb.append("-".repeat(MAX_AXIS_VALUE*2)).append(LINE_SEPARATOR);
        for (int x = MIN_AXIS_VALUE; x < MAX_AXIS_VALUE; x++) {
            appendXAxis(sb, x);
        }
        System.out.println(sb);
    }

    private void appendYAxis(StringBuilder sb, int y) {
        if(y %2 == 0) {
            sb.append(String.format("%2d", y));
            return;
        }
        sb.append(DOUBLE_BLANK);
    }

    private void appendCoordinateOrPass(StringBuilder sb, int y) {
        StringBuilder tmpSb = new StringBuilder();
        if(coordinate1.getY() == y && coordinate2.getY() == y) {
            tmpSb.append(DOUBLE_BLANK.repeat(coordinate1.getX()))
                    .append(POINT);
            appendSecondCoordinateInSameY(tmpSb);
            sb.append(tmpSb).append(LINE_SEPARATOR);
            return;
        }
        if(coordinate1.getY() == y) {
            tmpSb.append(DOUBLE_BLANK.repeat(coordinate1.getX()))
                    .append(".");
        }
        if(coordinate2.getY() == y) {
            tmpSb.append(DOUBLE_BLANK.repeat(coordinate2.getX()))
                    .append(POINT);
        }
        sb.append(tmpSb).append(LINE_SEPARATOR);
    }

    private void appendXAxis(StringBuilder sb, int x) {
        if(x%2 == 0) {
            sb.append(String.format("%4d", x));
        }
    }

    private void appendSecondCoordinateInSameY(StringBuilder tmpSb) {
        if(coordinate2.getX() < coordinate1.getX()) {
            tmpSb.deleteCharAt(0).insert(coordinate2.getX()*2, POINT);
            return;
        }
        tmpSb.append("  ".repeat(coordinate1.getX()-coordinate2.getX()-1))
                .append(" ").append(POINT);
    }
}
