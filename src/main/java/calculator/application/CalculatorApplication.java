package calculator.application;

import calculator.*;
import calculator.domain.Number;
import calculator.domain.NumberParseTarget;

import java.util.List;

public class CalculatorApplication {
    private final Reader reader;
    private final List<InputValidator> inputValidators;
    private final List<InputDividingStrategy> inputDividingStrategies;
    private final NumbersConverter converter;
    private final NumberCalculator numberCalculator;
    private final Printer printer;

    public CalculatorApplication(Configuration configuration) {
        this.reader = configuration.reader();
        this.inputValidators = configuration.inputValidators();
        this.inputDividingStrategies = configuration.inputDividingStrategies();
        this.converter = configuration.numbersConverter();
        this.numberCalculator = configuration.numberCalculator();
        this.printer = configuration.printer();
    }

    public void run() {
        printer.print("덧셈할 문자열을 입력해 주세요.%n");

        String input = reader.read();
        inputValidators.forEach(validator -> validator.validate(input));

        NumberParseTarget target = NumberParseTarget.createDefault(input);
        for (InputDividingStrategy strategy : inputDividingStrategies) {
            if (!target.finished()) {
                target = strategy.divide(target);
            }
        }

        List<Number> numbers = converter.convert(target.results());
        Number result = numberCalculator.calculate(numbers);

        printer.print("결과 : %s%n", result);
    }
}
