package calculator.dividingstrategy;

import calculator.InputDividingStrategy;
import calculator.domain.NumberParseTarget;

import java.util.ArrayList;
import java.util.Arrays;

public class RestDividingStrategy implements InputDividingStrategy {

    public static final String REST = ",";

    @Override
    public NumberParseTarget divide(NumberParseTarget target) {
        if (target.isFirstDividing()) {
            var dividedInput = Arrays.stream(target.origin().split(REST)).toList();
            return new NumberParseTarget(target.origin(), dividedInput, isFinished(dividedInput));
        }

        var results = new ArrayList<String>();
        for (String input : target.results()) {
            results.addAll(Arrays.stream(input.split(REST)).toList());
        }
        return new NumberParseTarget(target.origin(), results, isFinished(results));
    }
}
