package calculator;

import calculator.domain.Number;

import java.util.List;

public interface NumberCalculator {
    Number calculate(List<Number> targets);
}
