package calculator.dividingstrategy;

import calculator.InputDividingStrategy;
import calculator.NumberParseTarget;

import java.util.ArrayList;
import java.util.Arrays;

public class ColonDividingStrategy implements InputDividingStrategy {

    public static final String COLON = ":";

    @Override
    public NumberParseTarget divide(NumberParseTarget target) {
        if (target.isFirstDividing()) {
            var dividedInput = Arrays.stream(target.origin().split(COLON)).toList();
            return new NumberParseTarget(target.origin(), dividedInput, isFinished(dividedInput));
        }

        var results = new ArrayList<String>();
        for (String input : target.results()) {
            results.addAll(Arrays.stream(input.split(COLON)).toList());
        }
        return new NumberParseTarget(target.origin(), results, isFinished(results));
    }
}
