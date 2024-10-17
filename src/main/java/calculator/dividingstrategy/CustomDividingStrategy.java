package calculator.dividingstrategy;

import calculator.InputDividingStrategy;
import calculator.domain.NumberParseTarget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomDividingStrategy implements InputDividingStrategy {
    @Override
    public NumberParseTarget divide(NumberParseTarget target) {
        if (!(target.origin().startsWith("//") && target.origin().contains("\\n"))) {
            return target;
        }
        String separator = String.valueOf(target.origin().charAt(2));
        String origin = target.origin().substring(5);

        if (target.isFirstDividing()) {
            List<String> dividedInput = Arrays.stream(origin.split(separator)).toList();
            return new NumberParseTarget(origin, dividedInput, isFinished(dividedInput));
        }

        List<String> results = new ArrayList<>();
        for (String input : target.results()) {
            results.addAll(Arrays.stream(input.split(separator)).toList());
        }
        return new NumberParseTarget(origin, results, isFinished(results));
    }
}
