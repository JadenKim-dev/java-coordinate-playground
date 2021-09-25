package line.domain;

import java.util.Objects;

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
        if(validateValue(value)) {
            throw new IllegalArgumentException("좌표값은 1에서 24 사이만 가능합니다.");
        }
        return new Value(value);
    }

    public static boolean validateValue(int value) {
        return value < MIN_BOUND || value > MAX_BOUND;
    }


    public static Value copyOf(Value target) {
        return new Value(target);
    }

    public int getDifferenceTo(Value otherValue) {
        return this.value - otherValue.value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value1 = (Value) o;
        return getValue() == value1.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
