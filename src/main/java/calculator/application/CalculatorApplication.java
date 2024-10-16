package calculator.application;

import calculator.*;

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

        var input = reader.read();
        inputValidators.forEach(validator -> validator.validate(input));

        var target = NumberParseTarget.createDefault(input);
        for (InputDividingStrategy strategy : inputDividingStrategies) {
            if (!target.finished()) {
                target = strategy.divide(target);
            }
        }

        var numbers = converter.convert(target.results());
        var result = numberCalculator.calculate(numbers);

        printer.print("결과 : %s%n", result);
    }
}
