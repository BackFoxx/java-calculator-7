package calculator.dividingstrategy;

import calculator.InputDividingStrategy;
import calculator.domain.NumberParseTarget;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomDividingStrategy implements InputDividingStrategy {
    @Override
    public NumberParseTarget divide(NumberParseTarget target) {
        if (!(target.origin().startsWith("//") && target.origin().contains("\\n"))) {
            return target;
        }
        var separator = String.valueOf(target.origin().charAt(2));
        var origin = target.origin().substring(5);

        if (target.isFirstDividing()) {
            var dividedInput = Arrays.stream(origin.split(separator)).toList();
            return new NumberParseTarget(origin, dividedInput, isFinished(dividedInput));
        }

        var results = new ArrayList<String>();
        for (String input : target.results()) {
            results.addAll(Arrays.stream(input.split(separator)).toList());
        }
        return new NumberParseTarget(origin, results, isFinished(results));
    }
}
