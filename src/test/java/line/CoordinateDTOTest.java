package line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CoordinateDTOTest {
    @Test
    @DisplayName("입력받은 좌표를 파싱하는 로직")
    void parseCoordinateDTOs() {
        String input = "(1,1)-(2,2)";
        List<CoordinateDTO> coordinateDTOS = CoordinateDTO.parseCoordinateDTOs(input);

        assertThat(coordinateDTOS)
                .containsExactly(CoordinateDTO.newInstance(1, 1), CoordinateDTO.newInstance(2, 2));
    }
}
