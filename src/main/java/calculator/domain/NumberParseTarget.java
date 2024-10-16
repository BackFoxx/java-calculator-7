package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public record NumberParseTarget(
        String origin,
        List<String> results,
        boolean finished
) {

    public static NumberParseTarget createDefault(String input) {
        return new NumberParseTarget(input, new ArrayList<>(), false);
    }

    public boolean isFirstDividing() {
        return results.isEmpty();
    }
}
