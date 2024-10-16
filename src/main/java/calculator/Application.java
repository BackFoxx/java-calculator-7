package calculator;

import calculator.application.CalculatorApplication;
import calculator.calculator.SumCalculator;
import calculator.converter.StreamNumbersConverter;
import calculator.dividingstrategy.ColonDividingStrategy;
import calculator.dividingstrategy.CustomDividingStrategy;
import calculator.dividingstrategy.RestDividingStrategy;
import calculator.inputvalidator.InvalidSymbolValidator;
import calculator.inputvalidator.SeparatorValidator;
import calculator.printer.ConsolePrinter;
import calculator.reader.ConsoleReader;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        var calculatorApplication = new CalculatorApplication(
                new ConsoleReader(),
                new SumCalculator(),
                new ConsolePrinter(),
                new StreamNumbersConverter(),
                List.of(
                        new CustomDividingStrategy(),
                        new ColonDividingStrategy(),
                        new RestDividingStrategy()
                ),
                List.of(
                        new InvalidSymbolValidator(),
                        new SeparatorValidator()
                )
        );

        calculatorApplication.run();
    }
}
