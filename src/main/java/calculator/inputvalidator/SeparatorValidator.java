package calculator.inputvalidator;

import calculator.InputValidator;

import java.util.List;

public class SeparatorValidator implements InputValidator {

    private static final List<Character> FORBIDDEN_SEPARATORS =
            List.of('1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '.', '$');

    @Override
    public void validate(String target) {
        if (!(target.startsWith("//") && target.contains("\\n"))) {
            return;
        }

        if (target.charAt(3) != '\\') {
            throw new IllegalArgumentException("구분자는 한 글자만 입력할 수 있습니다.");
        }

        char separator = target.charAt(2);
        if (FORBIDDEN_SEPARATORS.contains(separator)) {
            throw new IllegalArgumentException("사용할 수 없는 구분자입니다. 금지된 구분자 : %s".formatted(separator));
        }
    }
}
