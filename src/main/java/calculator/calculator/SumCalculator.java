package calculator.calculator;

import calculator.NumberCalculator;
import calculator.domain.Number;

import java.util.List;

public class SumCalculator implements NumberCalculator {
    @Override
    public Number calculate(List<Number> targets) {
        return targets.stream()
                .reduce(Number::sum)
                .orElse(Number.from(0));
    }
}
