package calculator.dividingstrategy;

import calculator.InputDividingStrategy;
import calculator.domain.NumberParseTarget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColonDividingStrategy implements InputDividingStrategy {

    public static final String COLON = ":";

    @Override
    public NumberParseTarget divide(NumberParseTarget target) {
        if (target.isFirstDividing()) {
            List<String> dividedInput = Arrays.stream(target.origin().split(COLON)).toList();
            return new NumberParseTarget(target.origin(), dividedInput, isFinished(dividedInput));
        }

        List<String> results = new ArrayList<>();
        for (String input : target.results()) {
            results.addAll(Arrays.stream(input.split(COLON)).toList());
        }
        return new NumberParseTarget(target.origin(), results, isFinished(results));
    }
}
