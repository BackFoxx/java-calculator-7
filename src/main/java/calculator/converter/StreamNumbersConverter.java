package calculator.converter;

import calculator.NumbersConverter;

import java.util.List;

public class StreamNumbersConverter implements NumbersConverter {
    @Override
    public List<Integer> convert(List<String> target) {
        try {
            return target.stream()
                    .map(String::trim)
                    .map(Integer::valueOf)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값을 계산할 수 없습니다.");
        }
    }
}
