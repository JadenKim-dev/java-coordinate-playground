package line;

import javax.xml.transform.Result;

public class ResultView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final int MAX_AXIS_VALUE = 24;
    private static final int MIN_AXIS_VALUE = 0;
    private static final String Y_AXIS_LINE_UNIT = "|";
    private static final String POINT = ".";
    private static final String DOUBLE_BLANK = "  ";

    private final CoordinateDTO coordinateDTO1;
    private final CoordinateDTO coordinateDTO2;
    private final Coordinate coordinate1;
    private final Coordinate coordinate2;

    private ResultView(Coordinate coordinate1, Coordinate coordinate2) {
        this.coordinateDTO1 = CoordinateDTO.from(coordinate1);
        this.coordinateDTO2 = CoordinateDTO.from(coordinate2);
        this.coordinate1 = coordinate1;
        this.coordinate2 = coordinate2;
    }

    public static ResultView newInstance(Coordinate coordinate1, Coordinate coordinate2) {
        return new ResultView(coordinate1, coordinate2);
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

    public void printLength() {
        StringBuilder sb = new StringBuilder();
        sb.append("두 점 사이 거리는 ")
                .append(String.format("%.6f", coordinate1.calculateLengthTo(coordinate2)));
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
        if(coordinateDTO1.getY() == y && coordinateDTO2.getY() == y) {
            tmpSb.append(DOUBLE_BLANK.repeat(coordinateDTO1.getX()))
                    .append(POINT);
            appendSecondCoordinateInSameY(tmpSb);
            sb.append(tmpSb).append(LINE_SEPARATOR);
            return;
        }
        if(coordinateDTO1.getY() == y) {
            tmpSb.append(DOUBLE_BLANK.repeat(coordinateDTO1.getX()))
                    .append(".");
        }
        if(coordinateDTO2.getY() == y) {
            tmpSb.append(DOUBLE_BLANK.repeat(coordinateDTO2.getX()))
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
        if(coordinateDTO2.getX() < coordinateDTO1.getX()) {
            tmpSb.deleteCharAt(0).insert(coordinateDTO2.getX()*2, POINT);
            return;
        }
        tmpSb.append("  ".repeat(coordinateDTO1.getX()- coordinateDTO2.getX()-1))
                .append(" ").append(POINT);
    }
}
