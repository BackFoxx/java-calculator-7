package calculator.printer;

import calculator.Printer;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String target, Object... args) {
        System.out.printf(target, args);
    }
}
