package line.view;

import line.controller.dto.CoordinateDTO;
import line.domain.Coordinates;

import java.util.List;

public class ResultView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final int MAX_AXIS_VALUE = 24;
    private static final int MIN_AXIS_VALUE = 0;
    private static final String Y_AXIS_LINE_UNIT = "|";
    private static final String POINT = ".";
    private static final String DOUBLE_BLANK = "  ";

    private final StringBuilder sb;

    private ResultView() {
        sb = new StringBuilder();
    }

    public static ResultView newInstance() {
        return new ResultView();
    }

    public void printGraph(Coordinates coordinates) {

        List<CoordinateDTO> coordinateDTOList = CoordinateDTO.getCoordinateDTOListFrom(coordinates);
        appendYAxisAndCoordinatesToSb(coordinateDTOList);
        appendXAxisToSb();

        System.out.println(sb);
    }

    public void printLength(double length) {
        StringBuilder sb = new StringBuilder();
        sb.append("두 점 사이 거리는 ")
                .append(String.format("%.6f", length));
        System.out.println(sb);
    }

    private void appendYAxisAndCoordinatesToSb(List<CoordinateDTO> coordinateDTOList) {
        for (int y = MAX_AXIS_VALUE; y > MIN_AXIS_VALUE; y--) {
            appendYTicks(y);
            sb.append(Y_AXIS_LINE_UNIT);
            appendCoordinateOrPass(coordinateDTOList, y);
        }
    }

    private void appendXAxisToSb() {
        sb.append("-".repeat(MAX_AXIS_VALUE*2)).append(LINE_SEPARATOR);
        for (int x = MIN_AXIS_VALUE; x < MAX_AXIS_VALUE; x++) {
            appendXticks(x);
        }
    }

    private void appendYTicks(int y) {
        if(y %2 == 0) {
            sb.append(String.format("%2d", y));
            return;
        }
        sb.append(DOUBLE_BLANK);
    }

    private void appendCoordinateOrPass(List<CoordinateDTO> coordinateDTOList, int y) {
        CoordinateDTO coordinateDTO1 = coordinateDTOList.get(0);
        CoordinateDTO coordinateDTO2 = coordinateDTOList.get(1);

        if(coordinateDTO1.hasYOf(y) && coordinateDTO2.hasYOf(y)) {
            sb.append(getStringOfTwoCoordinatesInSameY(coordinateDTO1, coordinateDTO2))
                    .append(LINE_SEPARATOR);
            return;
        }
        if(coordinateDTO1.getY() == y) {
            sb.append(getStringOfSingleCoordinate(coordinateDTO1));
        }
        if(coordinateDTO2.getY() == y) {
            sb.append(getStringOfSingleCoordinate(coordinateDTO2));
        }
        sb.append(LINE_SEPARATOR);
    }

    private String getStringOfSingleCoordinate(CoordinateDTO coordinateDTO) {
        StringBuilder tmpSb = new StringBuilder();
        return tmpSb.append(DOUBLE_BLANK.repeat(coordinateDTO.getX()))
                .append(POINT).toString();
    }

    private String getStringOfTwoCoordinatesInSameY(CoordinateDTO coordinateDTO1, CoordinateDTO coordinateDTO2) {
        StringBuilder tmpSb = new StringBuilder();
        tmpSb.append(getStringOfSingleCoordinate(coordinateDTO1));
        if(coordinateDTO1.getX() < coordinateDTO1.getX()) {
            tmpSb.deleteCharAt(0).insert(coordinateDTO2.getX()*2, POINT);
            return tmpSb.toString();
        }
        tmpSb.append("  ".repeat(coordinateDTO1.getX()- coordinateDTO2.getX()-1))
                .append(" ").append(POINT);
        return tmpSb.toString();
    }

    private void appendXticks(int x) {
        if(x%2 == 0) {
            sb.append(String.format("%4d", x));
        }
    }


}
