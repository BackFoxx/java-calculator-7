package calculator.inputvalidator;

import calculator.InputValidator;

import java.util.List;

public class InvalidSymbolValidator implements InputValidator {

    private static final List<String> FORBIDDEN_SYMBOLS =
            List.of("-", ".");

    @Override
    public void validate(String target) {
        for (String symbol : FORBIDDEN_SYMBOLS) {
            if (target.contains(symbol)) {
                throw new IllegalArgumentException("소수 또는 음수를 입력할 수 없습니다.");
            }
        }
    }
}
