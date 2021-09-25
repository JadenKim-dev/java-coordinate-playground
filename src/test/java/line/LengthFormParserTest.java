package line;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LengthFormParserTest {
    private LengthFormatParser parser;

    @BeforeEach
    void setUp() {
        parser = new LengthFormatParser();
    }

    @Test
    @DisplayName("입력받은 좌표를 파싱하는 로직")
    void parseCoordinates() {
        String correctInput = "(1,14)-(21,4)";
        String parenthesesMissedInput = "(1,1-(3,14)";
        String commaMissedInput = "(23 1)-(14,1)";
        String hyphenMissedInput = "(12,1)(21,15)";

        assertThat(parser.parseCoordinates(correctInput).containsAll(
                Coordinate.of(1, 14),
                Coordinate.of(21,4)
        )).isTrue();
        assertIllegalArgumentExceptionThrownFor(parenthesesMissedInput);
        assertIllegalArgumentExceptionThrownFor(commaMissedInput);
        assertIllegalArgumentExceptionThrownFor(hyphenMissedInput);
    }

    private void assertIllegalArgumentExceptionThrownFor(String wrongInput) {
        assertThatThrownBy(() -> parser.parseCoordinates(wrongInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
