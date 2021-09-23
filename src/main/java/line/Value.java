package line;

public class Value {

    public static final int MIN_BOUND = 1;
    public static final int MAX_BOUND = 24;
    private final int value;

    private Value(Value value) {
        this.value = value.value;
    }

    private Value(int value) {
        this.value = value;
    }

    public static Value of(int value) {
        if(value < MIN_BOUND || value > MAX_BOUND) {
            throw new IllegalArgumentException("좌표값은 1에서 24 사이만 가능합니다.");
        }
        return new Value(value);
    }


    public static Value copyOf(Value target) {
        return new Value(target);
    }

    public int getDifferenceTo(Value otherValue) {
        return this.value - otherValue.value;
    }
}
