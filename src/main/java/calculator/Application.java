package calculator;

import calculator.calculator.SumCalculator;
import calculator.dividingstrategy.ColonDividingStrategy;
import calculator.dividingstrategy.CustomDividingStrategy;
import calculator.dividingstrategy.RestDividingStrategy;
import calculator.inputvalidator.InvalidSymbolValidator;
import calculator.inputvalidator.SeparatorValidator;
import calculator.printer.ConsolePrinter;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final NumberCalculator numberCalculator = new SumCalculator();

    private static final Printer printer = new ConsolePrinter();

    private static final List<InputDividingStrategy> inputDividingStrategies = List.of(
            new CustomDividingStrategy(),
            new ColonDividingStrategy(),
            new RestDividingStrategy()
    );
    private static final List<InputValidator> inputValidators = List.of(
            new InvalidSymbolValidator(),
            new SeparatorValidator()
    );


    public static void main(String[] args) {
        printer.print("덧셈할 문자열을 입력해 주세요.%n");
        var input = Console.readLine();

        inputValidators.forEach(validator -> validator.validate(input));

        var target = new NumberParseTarget(input, new ArrayList<>(), false);
        for (InputDividingStrategy strategy : inputDividingStrategies) {
            if (!target.finished()) {
                target = strategy.parse(target);
            }
        }

        var numbers = convertNumbers(target);
        var result = numberCalculator.calculate(numbers);
        printer.print("결과 : %s%n", result);
    }

    private static List<Integer> convertNumbers(NumberParseTarget target) {
        try {
            return target.results().stream()
                    .map(String::trim)
                    .map(Integer::valueOf)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값을 계산할 수 없습니다.");
        }
    }
}
