package calculator;

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

public class Configuration {
    public Reader reader() {
        return new ConsoleReader();
    }

    public Printer printer() {
        return new ConsolePrinter();
    }

    public NumberCalculator numberCalculator() {
        return new SumCalculator();
    }

    public NumbersConverter numbersConverter() {
        return new StreamNumbersConverter();
    }

    public List<InputValidator> inputValidators() {
        return List.of(
                new InvalidSymbolValidator(),
                new SeparatorValidator()
        );
    }

    public List<InputDividingStrategy> inputDividingStrategies() {
        return List.of(
                new CustomDividingStrategy(),
                new ColonDividingStrategy(),
                new RestDividingStrategy()
        );
    }
}
