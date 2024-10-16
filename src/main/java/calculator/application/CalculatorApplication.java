package calculator.application;

import calculator.*;

import java.util.List;

public class CalculatorApplication {
    private final Reader reader;
    private final NumberCalculator numberCalculator;
    private final Printer printer;
    private final NumbersConverter converter;
    private final List<InputDividingStrategy> inputDividingStrategies;
    private final List<InputValidator> inputValidators;

    public CalculatorApplication(Reader reader, NumberCalculator numberCalculator, Printer printer, NumbersConverter converter, List<InputDividingStrategy> inputDividingStrategies, List<InputValidator> inputValidators) {
        this.reader = reader;
        this.numberCalculator = numberCalculator;
        this.printer = printer;
        this.converter = converter;
        this.inputDividingStrategies = inputDividingStrategies;
        this.inputValidators = inputValidators;
    }

    public void run() {
        printer.print("덧셈할 문자열을 입력해 주세요.%n");

        var input = reader.read();
        inputValidators.forEach(validator -> validator.validate(input));

        var target = NumberParseTarget.createDefault(input);
        for (InputDividingStrategy strategy : inputDividingStrategies) {
            if (!target.finished()) {
                target = strategy.parse(target);
            }
        }

        var numbers = converter.convert(target.results());
        var result = numberCalculator.calculate(numbers);

        printer.print("결과 : %s%n", result);
    }
}
