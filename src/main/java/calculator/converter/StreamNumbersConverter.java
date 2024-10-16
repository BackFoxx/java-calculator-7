package calculator.converter;

import calculator.NumbersConverter;
import calculator.domain.Number;

import java.util.List;

public class StreamNumbersConverter implements NumbersConverter {
    @Override
    public List<Number> convert(List<String> target) {
        try {
            return target.stream()
                    .map(Number::from)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값을 계산할 수 없습니다.");
        }
    }
}
