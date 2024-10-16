package calculator;

import java.util.List;

public record NumberParseTarget(
        String origin,
        List<String> results,
        boolean finished
) {
    public boolean isFirstDividing() {
        return results.isEmpty();
    }
}
