package line;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ValueTest {
    @Test
    @DisplayName("좌표 값이 1~24의 값인지 검증하는 로직")
    void create() {
        assertThatThrownBy(() -> Value.of(0)).isInstanceOf(IllegalArgumentException.class);
        assertDoesNotThrow(() -> Value.of(1));
        assertDoesNotThrow(() -> Value.of(24));
        assertThatThrownBy(() -> Value.of(25)).isInstanceOf(IllegalArgumentException.class);
    }
}
