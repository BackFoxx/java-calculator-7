package calculator;

import java.util.List;

public interface InputDividingStrategy {
    NumberParseTarget divide(NumberParseTarget target);

    default boolean isFinished(List<String> targets) {
        return targets.stream().allMatch(this::isNumber);
    }

    default boolean isNumber(String target) {
        try {
            Integer.valueOf(target);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
