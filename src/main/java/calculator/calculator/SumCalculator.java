package calculator.calculator;

import calculator.NumberCalculator;

import java.util.List;

public class SumCalculator implements NumberCalculator {
    @Override
    public Long calculate(List<Integer> targets) {
        return targets.stream()
                .map(Long::valueOf)
                .reduce(Long::sum)
                .orElse(0L);
    }
}
