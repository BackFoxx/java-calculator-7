package calculator;

import calculator.domain.Number;

import java.util.List;

public interface NumbersConverter {
    List<Number> convert(List<String> target);
}
