package calculator.domain;

public record Number(Integer value) {
    public static Number from(String value) {
        return new Number(Integer.valueOf(value));
    }

    public static Number from(Integer value) {
        return new Number(value);
    }

    public Number sum(Number number) {
        return Number.from(this.value + number.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
