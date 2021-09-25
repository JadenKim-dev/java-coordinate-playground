package line.domain;

import line.domain.Coordinate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class CoordinateTest {
    @Test
    @DisplayName("좌표 간 거리를 구하는 로직")
    void calculateLengthTo() {
        Coordinate point1 = Coordinate.of(1, 1);
        Coordinate point2 = Coordinate.of(4, 5);

        assertThat(point1.calculateLengthTo(point2)).isEqualTo(5.000, offset(0.00099));
    }
}
