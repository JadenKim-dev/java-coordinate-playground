package line;

public class Value {

    public static final int MIN_BOUND = 1;
    public static final int MAX_BOUND = 24;
    private final int value;

    private Value(int value) {
        this.value = value;
    }

    public static Value of(int value) {
        if(value < MIN_BOUND || value > MAX_BOUND) {
            throw new IllegalArgumentException("좌표값은 1에서 24 사이만 가능합니다.");
        }
        return new Value(value);
    }
}
